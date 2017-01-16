package com.xiangyang.controller.verify;

import com.xiangyang.AO.UserAO;
import com.xiangyang.AO.VerifyAO;
import com.xiangyang.BizResult;
import com.xiangyang.form.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
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
        if (loginForm != null && !StringUtils.isEmpty(loginForm.getEmail()) && !StringUtils.isEmpty(loginForm.getPassword())) {//传递的对象判空
            if (verifyAO.loginVerify(loginForm)) {
                logger.info("用户" + loginForm.getEmail() + "登录成功");
                UserInfoForm userInfoForm = new UserInfoForm();
                userInfoForm.setEmail(loginForm.getEmail());
                HttpSession session = request.getSession();
                session.setAttribute("userInfo", userInfoForm);
                return "redirect:/center.htm";//到中央控制界面
            } else {//账号密码错误
                BizResult bizResult = new BizResult();
                logger.info("用户" + loginForm.getEmail() + "登录失败");
                bizResult.setSuccess(false);
                bizResult.setMsg("账号密码错误");
                modelMap.addAttribute("result", bizResult);
                return "verify/login";
            }
        } else {//无内容非法请求
            BizResult bizResult = new BizResult();
            bizResult.setSuccess(false);
            bizResult.setMsg("请求非法");
            modelMap.addAttribute("result", bizResult);
            return "verify/login";
        }
    }

}
