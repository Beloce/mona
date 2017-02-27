package com.xiangyang.AO.impl;

import com.xiangyang.AO.ErrorAO;
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
import com.xiangyang.model.DepartmentDO;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.UserDO;
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
        errorDO.setStatus(ErrorStatusEnum.Create.getCode());
        errorDO.setGmtCreate(nowData);
        errorDO.setGmtModified(nowData);
        errorManager.insertSelective(errorDO);

        return bizResult;
    }

    @Override
    public List<ErrorDO> queryBussinessErrorListByUserDO(UserDO userDO) {
        /*
        获取当前用户名下的所有业务问题
         */
        List<ErrorDO> errorDOs = new ArrayList<ErrorDO>();
        DepartmentDO departmentDO = new DepartmentDO();
        if(departmentDO == null || departmentDO.getDepartmentId() == null){
            return errorDOs;
        }
        ErrorQuery errorQuery = new ErrorQuery();
        errorQuery.createCriteria().andSourceEqualTo(ErrorSourceEnum.Business.getCode());

        return null;
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
            List<ErrorDO> errorDOs= errorManager.selectByQuery(errorQuery);
            List<ErrorVO> errorVOs = new ArrayList<ErrorVO>();
            for(ErrorDO errorDO : errorDOs){
                ErrorVO errorVO = new ErrorVO();
                BeanUtils.copyProperties(errorDO,errorVO);
                errorVO.setStatusDesc(ErrorStatusEnum.getDescByCode(errorDO.getStatus()));
                errorVO.setTypeDesc(ErrorTypeEnum.getDescByCode(errorDO.getType()));
                errorVO.setRelativeCreate(TimeUtils.formatRelativeTime(errorDO.getGmtCreate()));
                errorVO.setRelativeModified(TimeUtils.formatRelativeTime(errorDO.getGmtModified()));
                errorVOs.add(errorVO);
            }
            return errorVOs;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public BizResult<List<ErrorInfoDTO>> queryBussinessErrorList(QueryErrorForm queryErrorForm) {
        if(queryErrorForm == null){
            return null;
        }
        BizResult<List<ErrorInfoDTO>> bizResult = new BizResult<List<ErrorInfoDTO>>();
        List<ErrorInfoDTO> errorInfoDTOs = new ArrayList<ErrorInfoDTO>();
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
                UserDO providerDO = userManager.selectByPrimaryKey(errorDO.getProviderId());
                ErrorInfoDTO errorInfoDTO = new ErrorInfoDTO();
                ErrorVO errorVO = new ErrorVO();
                BeanUtils.copyProperties(errorDO,errorVO);//拷贝DO到VO
                errorVO.setStatusDesc(ErrorStatusEnum.getDescByCode(errorDO.getStatus()));
                errorVO.setTypeDesc(ErrorTypeEnum.getDescByCode(errorDO.getType()));
                errorInfoDTO.setErrorVO(errorVO);//问题的model
                errorInfoDTO.setUserDO(providerDO);//提问者的model
                errorInfoDTOs.add(errorInfoDTO);
            }
            bizResult.setSuccess(true);
        }catch (Exception e){
            logger.error(e.getMessage());
            bizResult.setSuccess(false);
        }
        bizResult.setResult(errorInfoDTOs);
        return bizResult;
    }
}
