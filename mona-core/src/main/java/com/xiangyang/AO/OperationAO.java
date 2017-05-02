package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.form.opeartion.PostBusOpForm;
import com.xiangyang.form.opeartion.PostDevOpForm;

import java.util.LinkedHashMap;

/**
 * Created by xiangyang on 17/4/21.
 */
public interface OperationAO {

    /**
     * 获取技术人员对问题的操作权限
     * @param errorId
     * @param userId
     */
    LinkedHashMap<String,Integer> getDevErrorOperationSignal(Long errorId, Long userId);


    /**
     * 获取业务人员对问题的操作权限
     * @param errorId
     * @param userId
     */
    LinkedHashMap<String,Integer> getBusErrorOperationSignal(Long errorId, Long userId);


    /**
     * 技术人员进行问题操作
     * @param postDevOpForm
     * @return
     */
    BizResult doDevOperation(PostDevOpForm postDevOpForm);

    /**
     * 业务人员进行问题操作
     * @param postBusOpForm
     * @return
     */
    BizResult doBusOperation(PostBusOpForm postBusOpForm);

}
