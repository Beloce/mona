package com.xiangyang.AO.impl;

import com.xiangyang.AO.*;
import com.xiangyang.enums.error.ErrorStatusEnum;
import com.xiangyang.enums.error.OperationSignalEnum;
import com.xiangyang.manager.ErrorManager;
import com.xiangyang.model.ErrorDO;
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
