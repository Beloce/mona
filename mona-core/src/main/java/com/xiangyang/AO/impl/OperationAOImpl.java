package com.xiangyang.AO.impl;

import com.xiangyang.AO.*;
import com.xiangyang.BizResult;
import com.xiangyang.enums.error.ErrorStatusEnum;
import com.xiangyang.enums.error.OperationSignalEnum;
import com.xiangyang.enums.errorrecord.ErrorRecordOpTypeEnum;
import com.xiangyang.form.opeartion.PostOpForm;
import com.xiangyang.manager.ErrorManager;
import com.xiangyang.manager.ErrorRecordManager;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.ErrorRecordDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * Created by xiangyang on 17/4/21.
 */
@Service
public class OperationAOImpl implements OperationAO{
    final Logger logger  =  LoggerFactory.getLogger(this.getClass());
    @Autowired
    ErrorAO errorAO;

    @Autowired
    ErrorManager errorManager;

    @Autowired
    TeamAO teamAO;

    @Autowired
    ErrorRecordAO errorRecordAO;

    @Autowired
    ErrorRecordManager errorRecordManager;

    @Autowired
    TeamUserAO teamUserAO;

    @Autowired
    ProductAO productAO;


    public LinkedHashMap<String,Integer> getDevErrorOperationSignal(Long errorId, Long userId){
        LinkedHashMap<String,Integer> opMap = new LinkedHashMap<>();
        if(errorId == null || userId == null){
            return opMap;
        }
        try{
            //相对于技术方人员来说
            ErrorDO errorDO = errorManager.selectByPrimaryKey(errorId);
            Long productId = errorDO.getProductId();
            if(isErrorBelongTechUser(productId,userId)){
                if(errorDO.getStatus().equals(ErrorStatusEnum.CREATED.getCode())){//问题已创建
                    opMap.put(OperationSignalEnum.CONFIRM_ERROR.getDesc(),OperationSignalEnum.CONFIRM_ERROR.getCode());
                    if(isUserTheLeader(productId,userId)){
                        opMap.put(OperationSignalEnum.POINT_ERROR.getDesc(),OperationSignalEnum.POINT_ERROR.getCode());
                    }
                }
                if(errorDO.getStatus().equals(ErrorStatusEnum.CONFIRMED.getCode())
                        && errorRecordAO.getHeadTechUserId(errorId).equals(userId)){//问题已确认,getCode
                    opMap.put(OperationSignalEnum.SOLVE_ERROR.getDesc(),OperationSignalEnum.SOLVE_ERROR.getCode());//已解决问题
                    opMap.put(OperationSignalEnum.CLOSE_ERROR.getDesc(),OperationSignalEnum.CLOSE_ERROR.getCode());//关闭问题
                }
                if(errorDO.getStatus().equals(ErrorStatusEnum.EVALUATED.getCode())
                        && errorRecordAO.getHeadTechUserId(errorId).equals(userId)){//问题已被评价，等待填写问题清单
                    opMap.put(OperationSignalEnum.FILL_INVENTORY_ERROR.getDesc(),OperationSignalEnum.FILL_INVENTORY_ERROR.getCode());
                }
            }
        }catch (Exception e){
            logger.error(e.toString());
        }
        return opMap;
    }

    @Override
    public LinkedHashMap<String, Integer> getBusErrorOperationSignal(Long errorId, Long userId) {
        return null;
    }

    @Override
    public BizResult doDevOperation(PostOpForm postOpForm) {
        BizResult bizResult = new BizResult();
        UserDO userDO = UserUtil.getUser();
        try{
            ErrorDO errorDO = errorManager.selectByPrimaryKey(postOpForm.getErrorId());
            if(!isErrorBelongTechUser(errorDO.getProductId(),userDO.getUserId())){
                bizResult.setMsg("您无权限进行此操作");
                bizResult.setSuccess(false);
                return bizResult;
            }
            ErrorRecordDO errorRecordDO = new ErrorRecordDO();
            errorRecordDO.setErrorId(errorDO.getErrorId());//问题记录的问题ID
            errorRecordDO.setOperatorId(userDO.getUserId());//操作者的ID

            if(postOpForm.getOpid().equals(OperationSignalEnum.CONFIRM_ERROR.getCode())){//确认问题
                errorDO.setStatus(ErrorStatusEnum.CONFIRMED.getCode());
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.CONFIRM.getCode());
            }
            else if(postOpForm.getOpid().equals(OperationSignalEnum.POINT_ERROR.getCode())){//指派问题
            /*
             问题指派的相关代码 todo
             */
                errorDO.setStatus(ErrorStatusEnum.CLOSED.getCode());
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.POINT.getCode());
            }
            else if(postOpForm.getOpid().equals(OperationSignalEnum.CLOSE_ERROR.getCode())){//关闭问题
                errorDO.setStatus(ErrorStatusEnum.CLOSED.getCode());
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.CLOSE.getCode());
            }
            else if(postOpForm.getOpid().equals(OperationSignalEnum.SOLVE_ERROR.getCode())){//解决问题
                errorDO.setStatus(ErrorStatusEnum.PROCESSED.getCode());
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.RESOLVE.getCode());
            }
            else if(postOpForm.getOpid().equals(OperationSignalEnum.FILL_INVENTORY_ERROR)){//填写问题清单
            /*
            填写问题清单。。。todo
             */
                errorDO.setStatus(ErrorStatusEnum.OVER.getCode());
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.FILL_INVENTORY.getCode());
            }
            else{
                bizResult.setMsg("异常操作");
                bizResult.setSuccess(false);
                return bizResult;
            }
            errorRecordManager.insertSelective(errorRecordDO);
            errorManager.updateByPrimaryKeySelective(errorDO);
        }catch (Exception e){
            bizResult.setSuccess(false);
            logger.error(e.toString());
            return bizResult;
        }
        bizResult.setSuccess(true);
        return bizResult;
    }


    /*
    该问题是否是该用户是否有管理权限针对技术人员
    */
    private boolean isErrorBelongTechUser(Long productId, Long userId){
        Long teamId = productAO.queryTeamIdByProductId(productId);
        return teamUserAO.isUserInTeam(userId,teamId);
    }

    /*
    该用户是否为leader
     */
    private boolean isUserTheLeader(Long productId,Long userId){
        Long teamId = productAO.queryTeamIdByProductId(productId);
        return teamUserAO.isUserTheLeader(userId,teamId);
    }
}
