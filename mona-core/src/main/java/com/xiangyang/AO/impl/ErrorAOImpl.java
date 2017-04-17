package com.xiangyang.AO.impl;

import com.xiangyang.AO.ErrorAO;
import com.xiangyang.AO.ProductAO;
import com.xiangyang.AO.TeamAO;
import com.xiangyang.AO.TeamUserAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.ErrorVO;
import com.xiangyang.dto.ErrorInfoDTO;
import com.xiangyang.enums.error.ErrorSourceEnum;
import com.xiangyang.enums.error.ErrorStatusEnum;
import com.xiangyang.enums.error.ErrorTypeEnum;
import com.xiangyang.form.error.ErrorForm;
import com.xiangyang.form.error.QueryErrorForm;
import com.xiangyang.manager.ErrorManager;
import com.xiangyang.manager.UserManager;
import com.xiangyang.model.*;
import com.xiangyang.query.ErrorQuery;
import com.xiangyang.util.TimeUtils;
import com.xiangyang.util.query.support.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiangyang on 17/2/9.
 */
@Service
public class ErrorAOImpl implements ErrorAO {

    final Logger logger  =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    ErrorManager errorManager;

    @Autowired
    UserManager userManager;

    @Autowired
    TeamUserAO teamUserAO;

    @Autowired
    ProductAO productAO;

    @Override
    public BizResult addNewError(ErrorForm errorForm) {
        BizResult bizResult = new BizResult();
        if(errorForm == null){
            bizResult.setMsg("信息为空");
            return bizResult;
        }
        ErrorDO errorDO = new ErrorDO();
        Date nowData = TimeUtils.getNow();
        errorDO.setTitle(errorForm.getTitle());
        errorDO.setDescription(errorForm.getDescription());
        errorDO.setProductId(errorForm.getProductId());
        errorDO.setProviderId(errorForm.getUserDO().getUserId());
        errorDO.setType(errorForm.getErrorType());
        errorDO.setScreenshot(errorForm.getScreenshot());
        errorDO.setSource(ErrorSourceEnum.Business.getCode());
        errorDO.setStatus(ErrorStatusEnum.CREATED.getCode());
        errorDO.setGmtCreate(nowData);
        errorDO.setGmtModified(nowData);
        errorManager.insertSelective(errorDO);

        return bizResult;
    }

    @Override
    public List<ErrorVO> queryBussinessErrorListByUserDO(UserDO userDO) {
        List<ErrorVO> errorVOs = new ArrayList<>();

        if(userDO == null){
            return errorVOs;
        }
        try {
            List<Long> teamIds = teamUserAO.findTeamIdsByUserId(userDO.getUserId());
            List<Long> productIds = productAO.findProductIdsByTeamIds(teamIds);
            errorVOs = this.queryWaitBussErrorsByProductIds(productIds);
            for(ErrorVO errorVO : errorVOs){
                errorVO.setProviderFlowerName(userDO.getFlowerName());
                errorVO.setProviderRealName(userDO.getRealName());
            }
        }catch (Exception e){
            logger.error("|===用户："+userDO.getFlowerName()+" 正在查询问题业务，异常==|"+e.getMessage());
        }
        return errorVOs;
    }

    @Override
    public List<ErrorVO> queryUserBussinessErrorList(UserDO userDO,QueryErrorForm queryErrorForm) {
        if(userDO == null){
            return null;
        }
        if(queryErrorForm == null || queryErrorForm.getPageNo() == null || queryErrorForm.getPageSize() == null){
            return null;
        }
        try{
            ErrorQuery errorQuery = new ErrorQuery();
            errorQuery.setOrderByClause("status asc, type asc, error_id desc");//按照问题的状态正序排序
            errorQuery.setPageSize(queryErrorForm.getPageSize());
            errorQuery.setPageNo(queryErrorForm.getPageNo());
            errorQuery.createCriteria().andProviderIdEqualTo(userDO.getUserId());
            List<ErrorDO> errorDOs = errorManager.selectByQuery(errorQuery);
            List<ErrorVO> errorVOs = ErrorDOs2VOs(errorDOs);
            return errorVOs;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<ErrorVO> queryWaitBussErrorsByProductIds(List<Long> productIds) {
        List<ErrorVO> errorVOs = new ArrayList<>();
        if(productIds == null || productIds.size() == 0){
            return errorVOs;
        }
        ErrorQuery errorQuery = new ErrorQuery();

        List<Integer> statusList = new ArrayList<>();
        statusList.add(ErrorStatusEnum.CLOSED.getCode());
        statusList.add(ErrorStatusEnum.OVER.getCode());//关闭和完结的问题不被查询到
        errorQuery.createCriteria().andStatusNotIn(statusList).andProductIdIn(productIds);
        List<ErrorDO> errorDOs = errorManager.selectByQuery(errorQuery);
        errorVOs =  ErrorDOs2VOs(errorDOs);
        return errorVOs;

    }

    @Override
    public BizResult<List<ErrorVO>> queryBussinessErrorList(QueryErrorForm queryErrorForm) {
        BizResult<List<ErrorVO>> bizResult = new BizResult<List<ErrorVO>>();
        List<ErrorVO> errorVOs = new ArrayList<ErrorVO>();
        if(queryErrorForm == null){
            return bizResult;
        }
        try {
            ErrorQuery errorQuery = new ErrorQuery();
            //设置分页的大小和页数
            errorQuery.setPageNo(queryErrorForm.getPageNo());
            errorQuery.setPageSize(queryErrorForm.getPageSize());
            errorQuery.setOrderByClause("type asc, error_id desc");//倒序

            //简单分类筛选
            errorQuery.createCriteria().andSourceEqualTo(queryErrorForm.getErrorSource())
                    .andStatusIn(queryErrorForm.getStatus());

            PageResult<ErrorDO> errorDOs = errorManager.selectByQueryWithPage(errorQuery);
            //循环获取errorDO
            for(ErrorDO errorDO : errorDOs.getResult()){

                ErrorVO errorVO = new ErrorVO();
                BeanUtils.copyProperties(errorDO,errorVO);//拷贝DO到VO
                errorVO.setStatusDesc(ErrorStatusEnum.getDescByCode(errorDO.getStatus()));
                errorVO.setTypeDesc(ErrorTypeEnum.getDescByCode(errorDO.getType()));
                errorVOs.add(errorVO);
            }
            bizResult.setSuccess(true);
            bizResult.setResult(errorVOs);
        }catch (Exception e){
            logger.error(e.getMessage());
            bizResult.setSuccess(false);
        }
        bizResult.setResult(errorVOs);
        return bizResult;
    }

    @Override
    public ErrorVO findErrorVOById(Long errorId) {
        ErrorVO errorVO = new ErrorVO();
        try {
            ErrorDO errorDO = errorManager.selectByPrimaryKey(errorId);
            errorVO = ErrorVO2DO(errorDO);
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return errorVO;
    }

    private List<ErrorVO>  ErrorDOs2VOs(List<ErrorDO> errorDOs){
        List<ErrorVO> errorVOs = new ArrayList<>();
        for(ErrorDO errorDO : errorDOs){
            ErrorVO errorVO = new ErrorVO();
            BeanUtils.copyProperties(errorDO,errorVO);
            UserDO providerDO = userManager.selectByPrimaryKey(errorDO.getProviderId());
            errorVO.setProviderFlowerName(providerDO.getFlowerName());
            errorVO.setProviderRealName(providerDO.getRealName());
            errorVO.setStatusDesc(ErrorStatusEnum.getDescByCode(errorDO.getStatus()));
            errorVO.setTypeDesc(ErrorTypeEnum.getDescByCode(errorDO.getType()));
            errorVO.setRelativeCreate(TimeUtils.formatRelativeTime(errorDO.getGmtCreate()));
            errorVO.setRelativeModified(TimeUtils.formatRelativeTime(errorDO.getGmtModified()));
            errorVOs.add(errorVO);
        }
        return errorVOs;
    }

    private ErrorVO ErrorVO2DO(ErrorDO errorDO){
        ErrorVO errorVO = new ErrorVO();
        BeanUtils.copyProperties(errorDO,errorVO);
        UserDO providerDO = userManager.selectByPrimaryKey(errorDO.getProviderId());
        errorVO.setProviderFlowerName(providerDO.getFlowerName());
        errorVO.setProviderRealName(providerDO.getRealName());
        errorVO.setStatusDesc(ErrorStatusEnum.getDescByCode(errorDO.getStatus()));
        errorVO.setTypeDesc(ErrorTypeEnum.getDescByCode(errorDO.getType()));
        errorVO.setRelativeCreate(TimeUtils.formatRelativeTime(errorDO.getGmtCreate()));
        errorVO.setRelativeModified(TimeUtils.formatRelativeTime(errorDO.getGmtModified()));
        return errorVO;
    }
}
