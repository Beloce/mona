package com.xiangyang.controller.verify;

import com.xiangyang.AO.UserAO;
import com.xiangyang.AO.VerifyAO;
import com.xiangyang.BizResult;
import com.xiangyang.form.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xiangyang on 16/11/1.
 */
@RequestMapping("/verify")
@Controller
public class VerifyController {
    final Logger logger  =  LoggerFactory.getLogger(this.getClass());
    @Autowired
    VerifyAO verifyAO;

    @Autowired
    UserAO userAO;

    /**
     * 登录界面转跳
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "/verify/login";
    }

    /**
     * 登录验证请求
     * @param loginForm 登录表单对象
     * @return url
     */
    @RequestMapping("/loginVerify")
    public String loginVerify(LoginForm loginForm, ModelMap modelMap, HttpServletRequest request) {
        try {
            //利用shiro来进行登录认证
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(loginForm.getEmail(), loginForm.getPassword()));

        } catch (Exception e) {
            logger.error("登陆失败[userName=" + loginForm.getEmail() + "]", e);
            return "redirect:/verify/login.htm";
        }
        return "redirect:/center.htm";
    }

}
