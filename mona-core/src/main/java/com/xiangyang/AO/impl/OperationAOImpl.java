package com.xiangyang.AO.impl;

import com.xiangyang.AO.*;
import com.xiangyang.BizResult;
import com.xiangyang.enums.error.ErrorStatusEnum;
import com.xiangyang.enums.error.OperationSignalEnum;
import com.xiangyang.enums.errorrecord.ErrorRecordOpTypeEnum;
import com.xiangyang.form.opeartion.PostBusOpForm;
import com.xiangyang.form.opeartion.PostDevOpForm;
import com.xiangyang.manager.ErrorManager;
import com.xiangyang.manager.ErrorRecordManager;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.ErrorRecordDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
                if(errorDO.getStatus().equals(ErrorStatusEnum.VALIDATED.getCode())
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
    public BizResult doDevOperation(PostDevOpForm postDevOpForm) {
        BizResult bizResult = new BizResult();
        UserDO userDO = UserUtil.getUser();
        try{
            ErrorDO errorDO = errorManager.selectByPrimaryKey(postDevOpForm.getErrorId());
            if(!isErrorBelongTechUser(errorDO.getProductId(),userDO.getUserId())){
                bizResult.setMsg("您无权限进行此操作");
                bizResult.setSuccess(false);
                return bizResult;
            }
            ErrorRecordDO errorRecordDO = new ErrorRecordDO();
            errorRecordDO.setErrorId(errorDO.getErrorId());//问题记录的问题ID
            errorRecordDO.setOperatorId(userDO.getUserId());//操作者的ID
            errorRecordDO.setMemo(postDevOpForm.getMemo());//备注信息

            //确认问题-----------------------------------------------------------
            if(postDevOpForm.getOpid().equals(OperationSignalEnum.CONFIRM_ERROR.getCode())){//确认问题
                errorDO.setStatus(ErrorStatusEnum.CONFIRMED.getCode());
                errorRecordDO.setMemo("预计完成时间："+postDevOpForm.getMemo());
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.CONFIRM.getCode());
            }
            //指派问题-----------------------------------------------------------
            else if(postDevOpForm.getOpid().equals(OperationSignalEnum.POINT_ERROR.getCode()) && postDevOpForm.getPointTo()!=null){//指派问题
                Long originalProductId = errorDO.getProductId();//原来的问题id
                errorDO.setProductId(postDevOpForm.getPointTo());
                errorRecordDO.setOriginalProductId(originalProductId);
                errorRecordDO.setReplaceProductId(postDevOpForm.getPointTo());
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.POINT.getCode());
            }
            //关闭问题-----------------------------------------------------------
            else if(postDevOpForm.getOpid().equals(OperationSignalEnum.CLOSE_ERROR.getCode())){//关闭问题
                errorDO.setStatus(ErrorStatusEnum.CLOSED.getCode());
                errorDO.setReason(postDevOpForm.getReason());
                errorRecordDO.setMemo("问题关闭原因："+postDevOpForm.getMemo());
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.CLOSE.getCode());
            }
            //问题解决-----------------------------------------------------------
            else if(postDevOpForm.getOpid().equals(OperationSignalEnum.SOLVE_ERROR.getCode())){//解决问题
                errorDO.setStatus(ErrorStatusEnum.PROCESSED.getCode());
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.RESOLVE.getCode());
            }
            else if(postDevOpForm.getOpid().equals(OperationSignalEnum.FILL_INVENTORY_ERROR.getCode())){//填写问题清单
                errorDO.setReason(postDevOpForm.getReason());
                errorDO.setResponsibility(postDevOpForm.getRespType());
                errorDO.setResolveType(postDevOpForm.getResolveType());
                errorDO.setStatus(ErrorStatusEnum.OVER.getCode());
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.FILL_INVENTORY.getCode());
            }
            else{
                bizResult.setMsg("异常操作");
                bizResult.setSuccess(false);
                return bizResult;
            }
            ErrorRecordDO finishErrorRecordDO = new ErrorRecordDO();
            BeanUtils.copyProperties(errorRecordDO,finishErrorRecordDO);

            errorRecordManager.insertSelective(errorRecordDO);
            errorManager.updateByPrimaryKeySelective(errorDO);
            if(postDevOpForm.getOpid().equals(OperationSignalEnum.FILL_INVENTORY_ERROR.getCode())){
                finishErrorRecordDO.setOperationType(ErrorRecordOpTypeEnum.OVER.getCode());
                errorRecordManager.insertSelective(finishErrorRecordDO);
            }
            logger.info("技术人员 操作问题 No "+errorDO.getErrorId()+": 状态发生变更");

        }catch (Exception e){
            bizResult.setSuccess(false);
            logger.error(e.toString());
            return bizResult;
        }
        bizResult.setSuccess(true);
        return bizResult;
    }

    @Override
    public BizResult doBusOperation(PostBusOpForm postBusOpForm) {
        BizResult bizResult = new BizResult();
        UserDO userDO = UserUtil.getUser();
        try{
            ErrorDO errorDO = errorManager.selectByPrimaryKey(postBusOpForm.getErrorId());
            if(!isErrorBelongBusUser(errorDO,userDO.getUserId())){
                bizResult.setMsg("您无权限进行此操作");
                bizResult.setSuccess(false);
                return bizResult;
            }
            if(!errorDO.getStatus().equals(ErrorStatusEnum.PROCESSED.getCode())){
                bizResult.setMsg("已经提交请勿重复操作");
                bizResult.setSuccess(false);
                return bizResult;
            }
            ErrorRecordDO errorRecordDO = new ErrorRecordDO();
            errorRecordDO.setErrorId(postBusOpForm.getErrorId());//问题记录的问题ID
            errorRecordDO.setOperatorId(userDO.getUserId());//操作者的ID
            errorRecordDO.setMemo(postBusOpForm.getMemo());//备注信息

            if(postBusOpForm.getOpid().equals(OperationSignalEnum.CONFIRM_SOLVE_ERROR.getCode())){//确认问题已解决，且已评价
                errorDO.setStatus(ErrorStatusEnum.VALIDATED.getCode());
                errorDO.setAppraiseLevel(postBusOpForm.getAppraiseLevel());
                errorRecordDO.setMemo(postBusOpForm.getMemo()+" 评分："+postBusOpForm.getAppraiseLevel()+"星");
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.RESOLVE_CONFIRM.getCode());
            }
            if(postBusOpForm.getOpid().equals(OperationSignalEnum.REJECT_SOLVE_ERROR.getCode())){//问题未解决，被驳回
                errorDO.setStatus(ErrorStatusEnum.CONFIRMED.getCode());
                errorRecordDO.setMemo("驳回原因："+postBusOpForm.getMemo());
                errorRecordDO.setOperationType(ErrorRecordOpTypeEnum.RESOLVE_REJECT.getCode());
            }
            logger.info("业务人员 操作问题 No "+errorDO.getErrorId()+": 状态发生变更");
            errorRecordManager.insertSelective(errorRecordDO);
            errorManager.updateByPrimaryKeySelective(errorDO);
            bizResult.setSuccess(true);
        }catch (Exception e){
            logger.error(e.toString());
            bizResult.setSuccess(false);
            bizResult.setMsg("服务器异常");
        }
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
      该问题的发布者是否为该业务人员
       */
    private boolean isErrorBelongBusUser(ErrorDO errorDO,Long userId){
        if(userId!=null && userId.equals(errorDO.getProviderId())){
            return true;
        }else{
            return false;
        }
    }

    /*
    该用户是否为leader
     */
    private boolean isUserTheLeader(Long productId,Long userId){
        Long teamId = productAO.queryTeamIdByProductId(productId);
        return teamUserAO.isUserTheLeader(userId,teamId);
    }


}
