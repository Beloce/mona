package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.form.error.ErrorForm;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.UserDO;

import java.util.List;

/**
 * Created by xiangyang on 17/2/9.
 */
public interface ErrorAO {


    /**
     * 添加新的问题反馈
     * @param errorForm
     * @return
     */
    BizResult addNewError(ErrorForm errorForm);

    /**
     * 获取当前用户名下的业务问题列表
     * @param userDO
     * @return
     */
    List<ErrorDO> queryBussinessErrorListByUserDO(UserDO userDO);

}
