package com.xiangyang.AO.impl;

import com.xiangyang.AO.UserAO;
import com.xiangyang.AO.VerifyAO;
import com.xiangyang.form.LoginForm;
import com.xiangyang.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by xiangyang on 16/10/20.
 */
@Service
public class VerifyAOImpl implements VerifyAO {
    @Autowired
    UserAO userAO;

    public boolean loginVerify(LoginForm loginForm) {
        if(loginForm!=null&& !StringUtils.isEmpty(loginForm.getEmail())){
            UserDO userDO = userAO.selectUserByEmail(loginForm.getEmail());
            if(userDO!=null){
                if(loginForm.getPassword().equals(userDO.getPassword())){
                    return true;
                }else {//密码错误
                    return false;
                }
            }else {//没有相关用户
                return false;
            }
        }else{//登录表单为空
            return false;
        }

    }

}
