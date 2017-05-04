package com.xiangyang.AO.impl;

import com.xiangyang.AO.*;
import com.xiangyang.BizResult;
import com.xiangyang.VO.ErrorRecordVO;
import com.xiangyang.VO.ErrorVO;
import com.xiangyang.dto.ErrorInfoDTO;
import com.xiangyang.enums.error.*;
import com.xiangyang.enums.errorrecord.ErrorRecordOpTypeEnum;
import com.xiangyang.enums.errorrecord.ErrorRecordStatusEnum;
import com.xiangyang.form.error.ErrorForm;
import com.xiangyang.form.error.QueryErrorForm;
import com.xiangyang.manager.ErrorManager;
import com.xiangyang.manager.ErrorRecordManager;
import com.xiangyang.manager.ProductManager;
import com.xiangyang.manager.UserManager;
import com.xiangyang.model.*;
import com.xiangyang.query.ErrorQuery;
import com.xiangyang.query.ErrorRecordQuery;
import com.xiangyang.util.ImgUrlUtil;
import com.xiangyang.util.TimeUtils;
import com.xiangyang.util.UserUtil;
import com.xiangyang.util.query.support.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
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
    ProductManager productManager;

    @Autowired
    TeamUserAO teamUserAO;

    @Autowired
    ProductAO productAO;

    @Autowired
    ErrorRecordAO errorRecordAO;

    @Autowired
    ErrorRecordManager errorRecordManager;

    @Autowired
    TeamAO teamAO;

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
        errorRecordAO.addCreateErrorRecord(errorDO);//创建发布问题记录
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
                if(!userDO.getUserId().equals(errorRecordAO.getHeadTechUserId(errorVO.getErrorId()))){
                    errorVOs.remove(errorVO);
                }
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
    public List<ErrorVO> queryBussinessWaitErrorList(UserDO userDO, QueryErrorForm queryErrorForm) {
        if(userDO == null){
            return null;
        }
        if(queryErrorForm == null || queryErrorForm.getPageNo() == null || queryErrorForm.getPageSize() == null){
            return null;
        }
        try{
            ErrorQuery errorQuery = new ErrorQuery();
            errorQuery.setOrderByClause(" type asc, status asc, error_id desc");//按照问题的状态正序排序
            errorQuery.setPageSize(queryErrorForm.getPageSize());
            errorQuery.setPageNo(queryErrorForm.getPageNo());

            List<Integer> overStatus = new ArrayList<>();
            overStatus.add(ErrorStatusEnum.CLOSED.getCode());
            overStatus.add(ErrorStatusEnum.OVER.getCode());

            errorQuery.createCriteria().andProviderIdEqualTo(userDO.getUserId()).andStatusNotIn(overStatus);
            List<ErrorDO> errorDOs = errorManager.selectByQuery(errorQuery);
            List<ErrorVO> errorVOs = ErrorDOs2VOs(errorDOs);
            return errorVOs;
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public List<ErrorVO> queryBussinessOverErrorList(UserDO userDO, QueryErrorForm queryErrorForm) {
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

            List<Integer> overStatus = new ArrayList<>();
            overStatus.add(ErrorStatusEnum.CLOSED.getCode());
            overStatus.add(ErrorStatusEnum.OVER.getCode());

            errorQuery.createCriteria().andProviderIdEqualTo(userDO.getUserId()).andStatusIn(overStatus);
            List<ErrorDO> errorDOs = errorManager.selectByQuery(errorQuery);
            List<ErrorVO> errorVOs = ErrorDOs2VOs(errorDOs);
            return errorVOs;
        }catch (Exception e){
            logger.error(e.toString());
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
                    .andStatusIn(queryErrorForm.getStatusList());

            PageResult<ErrorDO> errorDOs = errorManager.selectByQueryWithPage(errorQuery);
            //循环获取errorDO
            errorVOs = ErrorDOs2VOs(errorDOs.getResult());
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
    public int countAllWaitToSolveError() {
        ErrorQuery errorQuery = new ErrorQuery();

        List<Integer> errorStatusList = new ArrayList<>();
        errorStatusList.add(ErrorStatusEnum.OVER.getCode());
        errorStatusList.add(ErrorStatusEnum.CLOSED.getCode());
        errorQuery.createCriteria().andStatusNotIn(errorStatusList);
        return errorManager.countByQuery(errorQuery);

    }

    @Override
    public int countTodayNewError() {
        ErrorQuery errorQuery = new ErrorQuery();
        errorQuery.createCriteria().andGmtCreateBetween(TimeUtils.getTodayStartTime(),TimeUtils.getTodayEndTime());
        return errorManager.countByQuery(errorQuery);
    }

    @Override
    public int countTodayDoneError() {
        List<Integer> errorReStatusList = new ArrayList<>();
        errorReStatusList.add(ErrorRecordOpTypeEnum.CLOSE.getCode());
        errorReStatusList.add(ErrorRecordOpTypeEnum.OVER.getCode());

        ErrorRecordQuery errorRecordQuery = new ErrorRecordQuery();
        errorRecordQuery.createCriteria().andOperationTypeIn(errorReStatusList).andGmtCreateBetween(TimeUtils.getTodayStartTime(),TimeUtils.getTodayEndTime());
        return errorRecordManager.countByQuery(errorRecordQuery);
    }

    @Override
    public ErrorVO findErrorVOById(Long errorId) {
        ErrorVO errorVO = new ErrorVO();
        try {
            ErrorDO errorDO = errorManager.selectByPrimaryKey(errorId);
            errorVO = ErrorDO2VO(errorDO);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return errorVO;
    }

    @Override
    public UserDO findSolverByErrorId(Long errorId) {
        UserDO userDO = new UserDO();
        ErrorRecordQuery errorRecordQuery = new ErrorRecordQuery();
        errorRecordQuery.createCriteria().andErrorIdEqualTo(errorId).andOperationTypeEqualTo(ErrorRecordOpTypeEnum.CONFIRM.getCode()).andStatusEqualTo(ErrorRecordStatusEnum.USING.getCode());
        errorRecordQuery.setOrderByClause("error_id desc");
        List<ErrorRecordDO> errorRecordDOs = errorRecordManager.selectByQuery(errorRecordQuery);
        if(errorRecordDOs.size() > 0){
            userDO = userManager.selectByPrimaryKey(errorRecordDOs.get(0).getOperatorId());
        }
        return userDO;
    }

    @Override
    public List<ErrorVO> findErrorVOByLogDate(Date date) {
        ErrorQuery errorQuery = new ErrorQuery();
        errorQuery.createCriteria().andGmtCreateBetween(TimeUtils.getDateStartTime(date),TimeUtils.getDateEndTime(date));
        List<ErrorDO> errorDOs = errorManager.selectByQuery(errorQuery);
        List<ErrorVO> errorVOs = this.ErrorDOs2VOs(errorDOs);
        for (ErrorVO errorVO : errorVOs){
            errorVO.setSolverFolwerName(findSolverByErrorId(errorVO.getErrorId()).getFlowerName());
        }
        return errorVOs;
    }

    @Override
    public List<ErrorVO> queryUserSolveErrorList(QueryErrorForm queryErrorForm) {
        ErrorRecordQuery errorRecordQuery = new ErrorRecordQuery();
        errorRecordQuery.createCriteria().andOperationTypeEqualTo(ErrorRecordOpTypeEnum.CONFIRM.getCode()).
                andStatusEqualTo(ErrorRecordStatusEnum.USING.getCode());
        errorRecordQuery.setPageNo(queryErrorForm.getPageNo());
        errorRecordQuery.setPageSize(queryErrorForm.getPageSize());
        errorRecordQuery.setOrderByClause("error_id desc");
        List<ErrorRecordDO> errorRecordDOs = errorRecordManager.selectByQuery(errorRecordQuery);
        List<Long> errorIds = new ArrayList<>();
        for(ErrorRecordDO errorRecordDO : errorRecordDOs){
            errorIds.add(errorRecordDO.getErrorId());
        }
        ErrorQuery errorQuery = new ErrorQuery();
        errorQuery.createCriteria().andErrorIdIn(errorIds);
        List<ErrorDO> errorDOs = errorManager.selectByQuery(errorQuery);
        return ErrorDOs2VOs(errorDOs);
    }

    @Override
    public List<ErrorVO> queryAllHisErrorList(QueryErrorForm queryErrorForm) {
        List<ErrorVO> errorVOs = new ArrayList<>();
        try {
            ErrorQuery errorQuery = new ErrorQuery();
            ErrorQuery.Criteria query = errorQuery.createCriteria();
            query.andErrorIdNotEqualTo(0l);
            if(queryErrorForm.getErrorType()!=null){
                query.andTypeEqualTo(queryErrorForm.getErrorType());
            }
            if(queryErrorForm.getProductId()!=null){
                query.andProductIdEqualTo(queryErrorForm.getProductId());
            }
            if(queryErrorForm.getStatus()!=null){
                query.andStatusEqualTo(queryErrorForm.getStatus());
            }
            errorQuery.setOrderByClause("error_id desc");
            errorQuery.setPageNo(queryErrorForm.getPageNo());
            errorQuery.setPageSize(queryErrorForm.getPageSize());
            List<ErrorDO> errorDOs = errorManager.selectByQuery(errorQuery);
            errorVOs =  ErrorDOs2VOs(errorDOs);
            for (ErrorVO errorVO : errorVOs){
                errorVO.setSolverFolwerName(findSolverByErrorId(errorVO.getErrorId()).getFlowerName());
            }
        }catch (Exception e){
            logger.error(e.toString());
        }
        return errorVOs;
    }

    @Override
    public int countQueryError(QueryErrorForm queryErrorForm) {
        int count = 0;
        try {
            ErrorQuery errorQuery = new ErrorQuery();
            ErrorQuery.Criteria query = errorQuery.createCriteria();
            query.andErrorIdNotEqualTo(0l);
            if(queryErrorForm.getErrorType()!=null){
                query.andTypeEqualTo(queryErrorForm.getErrorType());
            }
            if(queryErrorForm.getProductId()!=null){
                query.andProductIdEqualTo(queryErrorForm.getProductId());
            }
            if(queryErrorForm.getStatus()!=null){
                query.andStatusEqualTo(queryErrorForm.getStatus());
            }
            count = errorManager.countByQuery(errorQuery);

        }catch (Exception e){
            logger.error(e.toString());
        }
        return count;
    }


    private List<ErrorVO>  ErrorDOs2VOs(List<ErrorDO> errorDOs){
        List<ErrorVO> errorVOs = new ArrayList<>();
        for(ErrorDO errorDO : errorDOs){
            ErrorVO errorVO =ErrorDO2VO(errorDO);
            errorVOs.add(errorVO);
        }
        return errorVOs;
    }

    private ErrorVO ErrorDO2VO(ErrorDO errorDO){
        ErrorVO errorVO = new ErrorVO();
        BeanUtils.copyProperties(errorDO,errorVO);
        UserDO providerDO = userManager.selectByPrimaryKey(errorDO.getProviderId());
        ProductDO productDO = productManager.selectByPrimaryKey(errorDO.getProductId());
        errorVO.setProductName(productDO.getProductName());
        errorVO.setGmtCreateHourAndMin(TimeUtils.getHourAndMin(errorDO.getGmtCreate()));
        errorVO.setProviderFlowerName(providerDO.getFlowerName());
        errorVO.setProviderRealName(providerDO.getRealName());
        errorVO.setStatusDesc(ErrorStatusEnum.getDescByCode(errorDO.getStatus()));
        errorVO.setTypeDesc(ErrorTypeEnum.getDescByCode(errorDO.getType()));
        errorVO.setRelativeCreate(TimeUtils.formatRelativeTime(errorDO.getGmtCreate()));
        errorVO.setRelativeModified(TimeUtils.formatRelativeTime(errorDO.getGmtModified()));
        errorVO.setGmtCreateYYMMDD(TimeUtils.DateToStr(errorDO.getGmtCreate(),TimeUtils.YYYY_MM_DD));
        errorVO.setPics(ImgUrlUtil.parseList(errorDO.getScreenshot()));
        if(errorDO.getResolveType()!=null){
            errorVO.setResolDesc(ResolveTypeEnum.getDescByCode(errorDO.getResolveType()));
        }
        if(errorDO.getResponsibility()!=null){
            errorVO.setRespDesc(ResponsibilityEnum.getDescByCode(errorDO.getResponsibility()));
        }
        if(errorDO.getAppraiseLevel() !=null){
            errorVO.setAppraiseLevelDesc(errorVO.getAppraiseLevel()+"星");
        }
        return errorVO;
    }
}
