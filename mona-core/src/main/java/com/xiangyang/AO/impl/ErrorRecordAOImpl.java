package com.xiangyang.AO.impl;

import com.xiangyang.AO.ErrorRecordAO;
import com.xiangyang.VO.ErrorRecordVO;
import com.xiangyang.enums.error.ErrorStatusEnum;
import com.xiangyang.enums.errorrecord.ErrorRecordOpTypeEnum;
import com.xiangyang.enums.errorrecord.ErrorRecordStatusEnum;
import com.xiangyang.manager.ErrorManager;
import com.xiangyang.manager.ErrorRecordManager;
import com.xiangyang.manager.ProductManager;
import com.xiangyang.manager.UserManager;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.ErrorRecordDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.query.ErrorRecordQuery;
import com.xiangyang.util.ErrorRecodDescUtil;
import com.xiangyang.util.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by xiangyang on 17/4/18.
 */
@Service
public class ErrorRecordAOImpl implements ErrorRecordAO {
    final Logger logger  =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    ErrorRecordManager errorRecordManager;

    @Autowired
    ErrorManager errorManager;

    @Autowired
    ProductManager productManager;

    @Autowired
    UserManager userManager;

    @Override
    public boolean addCreateErrorRecord(ErrorDO errorDO) {
        if(errorDO == null){
            return false;
        }
        try {
            ErrorRecordDO errorRecordDO = new ErrorRecordDO();
            errorRecordDO.setErrorId(errorDO.getErrorId());
            errorRecordDO.setOperatorId(errorDO.getProviderId());
            errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.PUBLISH.getCode());
            errorRecordManager.insertSelective(errorRecordDO);
        }catch (Exception e){
            logger.error(e.getMessage());
            return  false;
        }
        return true;
    }

    @Override
    public List<ErrorRecordVO> queryErrorRecordList(Long errorId) {
        List<ErrorRecordVO> errorRecordVOs = new ArrayList<>();
        if(errorId == null){
            return errorRecordVOs;
        }
        try {
            ErrorRecordQuery query = new ErrorRecordQuery();
            query.createCriteria().andErrorIdEqualTo(errorId).andStatusEqualTo(ErrorRecordStatusEnum.USING.getCode());
            query.setOrderByClause("error_id asc");
            List<ErrorRecordDO> errorRecordDOs =  errorRecordManager.selectByQuery(query);
            for(ErrorRecordDO errorRecordDO : errorRecordDOs){
                ErrorRecordVO errorRecordVO = new ErrorRecordVO();
                errorRecordVOs.add(this.recordDO2VO(errorRecordDO));
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return errorRecordVOs;
    }


    /**
     *获得目前正在跟进的技术人员Id
     * @param errorId
     * @return null:说明当前没有人确认接收该问题
     */
    @Override
    public Long getHeadTechUserId(Long errorId) {
        ErrorRecordQuery query = new ErrorRecordQuery();
        query.createCriteria().andErrorIdEqualTo(errorId).andOperationTypeEqualTo(ErrorRecordOpTypeEnum.CONFIRM.getCode());
        query.setOrderByClause("record_id desc");
        List<ErrorRecordDO> errorRecordDOs = errorRecordManager.selectByQuery(query);
        if(!CollectionUtils.isEmpty(errorRecordDOs) && errorRecordDOs.size() > 0){
            return errorRecordDOs.get(0).getOperatorId();
        }else{
            return null;
        }
    }


    private ErrorRecordVO recordDO2VO(ErrorRecordDO errorRecordDO){
        ErrorRecordVO errorRecordVO = new ErrorRecordVO();
        if(errorRecordDO == null){
            return errorRecordVO;
        }
        BeanUtils.copyProperties(errorRecordDO,errorRecordVO);
        errorRecordVO.setOperatorFlowerName(userManager.selectByPrimaryKey(errorRecordVO.getOperatorId()).getFlowerName());
        if(errorRecordVO.getOperatorId()!=null && errorRecordVO.getReplaceProductId()!=null){
            errorRecordVO.setOriginalProductName(productManager.selectByPrimaryKey(errorRecordVO.getOriginalProductId()).getProductName());
            errorRecordVO.setReplacementProductName(productManager.selectByPrimaryKey(errorRecordVO.getReplaceProductId()).getProductName());
        }
        errorRecordVO.setOperationTypeName(ErrorRecordOpTypeEnum.getDescByCode(errorRecordVO.getOperationType()));
        errorRecordVO.setOperationTypeDesc(ErrorRecodDescUtil.transOperation(errorRecordDO.getOperationType(),errorRecordVO));
        errorRecordVO.setRelativeCreate(TimeUtils.formatRelativeTime(errorRecordDO.getGmtCreate()));
        return errorRecordVO;
    }
}
