package com.xiangyang.AO;

import com.xiangyang.form.LoginForm;

import java.util.List;

/**
 * Created by xiangyang on 16/10/18.
 */
public interface VerifyAO {

     /**
      * 登录验证
      * @param loginForm 登录表单
      * @return true or false
      */
     boolean loginVerify(LoginForm loginForm);

}
