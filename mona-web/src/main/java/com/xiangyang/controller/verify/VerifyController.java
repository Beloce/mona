package com.xiangyang.controller.verify;

import com.xiangyang.AO.DepartmentAO;
import com.xiangyang.AO.UserAO;
import com.xiangyang.AO.VerifyAO;
import com.xiangyang.BizResult;
import com.xiangyang.enums.department.DepartmentTypeEnum;
import com.xiangyang.form.*;
import com.xiangyang.model.UserDO;
import com.xiangyang.util.UserUtil;
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

    @Autowired
    DepartmentAO departmentAO;

    /**
     * 登录界面转跳
     * @return
     */
    @RequestMapping("/login.htm")
    public String login(HttpServletRequest request){
        return "/verify/login";
    }

    /**
     * 登录验证请求
     * @param loginForm 登录表单对象
     * @return url
     */
    @RequestMapping("/loginVerify.htm")
    public String loginVerify(LoginForm loginForm, ModelMap modelMap, HttpServletRequest request) {
        try {
            //利用shiro来进行登录认证
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(loginForm.getEmail(), loginForm.getPassword()));

        } catch (Exception e) {
            logger.error("登陆失败[userName=" + loginForm.getEmail() + "]", e);
            return "redirect:/verify/login.htm";
        }
        return "redirect:/verify/success.htm";
    }

    /**
     * 界面路由，区分部门的角色对应的页面
     * @param modelMap
     * @return
     */
    @RequestMapping("/success.htm")
    public String success(ModelMap modelMap){
        UserDO userDO = UserUtil.getUser();
        if(userDO == null || userDO.getDepartmentId() == null){
            modelMap.addAttribute("msg","当前您没有权限，请联系管理员");
        }
        logger.info("|----------用户: " + userDO.getFlowerName()+ " 登录----------|");
        if(departmentAO.queryDepartmentTypeById(userDO.getDepartmentId()).equals(DepartmentTypeEnum.Tech.getCode())){//技术岗的同学
            return "redirect:/center.htm";
        }else {//非技术岗同学
            return "redirect:/error/createError.htm";
        }
    }


}
