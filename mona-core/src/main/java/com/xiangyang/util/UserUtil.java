package com.xiangyang.util;

import com.xiangyang.form.UserInfoForm;

import javax.servlet.http.HttpSession;

/**
 * Created by peiji on 2016/12/3.
 */
public class UserUtil {
    /**
     * 从session中获取UserInfoForm对象
     * @param session
     * @return
     */
    public static UserInfoForm getUserInfoFormBySession(HttpSession session){
        return (UserInfoForm) session.getAttribute("userInfo");
    }
}
