package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.form.opeartion.PostOpForm;

import java.util.LinkedHashMap;
import java.util.Map;

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
     * 进行问题操作
     * @param postOpForm
     * @return
     */
    BizResult doDevOperation(PostOpForm postOpForm);

}
