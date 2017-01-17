package com.xiangyang.util;

import com.xiangyang.contants.SessionContants;
import com.xiangyang.form.UserInfoForm;
import com.xiangyang.model.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpSession;

/**
 * Created by peiji on 2016/12/3.
 */
public class UserUtil {
    /**
     * 获取当前登录用户信息
     * @return UserDO
     */
    public static UserDO getUser(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        return (UserDO) session.getAttribute(SessionContants.USER_DO_KEY);
    }
}
