package com.xiangyang.controller.verify;

import com.xiangyang.AO.*;
import com.xiangyang.BizResult;
import com.xiangyang.enums.RoleEnum;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

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

    @Autowired
    OperationAO operationAO;

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
            logger.error("登陆失败[userName=" + loginForm.getEmail() + "]");
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
        logger.info("|----------用户: " + userDO.getFlowerName()+ " 登录----------|");
        if(userDO.getRole() == null){//技术岗or管理员的同学
            modelMap.addAttribute("msg","您当前没有权限访问,请联系管理员开通权限");
            return "redirect:/error.htm";
        }else if(userDO.getRole().equals(RoleEnum.clerk.getCode())){//非技术岗同学
            return "redirect:/mobileError/mobileCreateError.htm";
        }else if(userDO.getRole().equals(RoleEnum.admin.getCode()) || userDO.getRole().equals(RoleEnum.developer.getCode())){//技术人员或者管理员
            return "redirect:/center.htm";
        }else{
            modelMap.addAttribute("msg","您当前没有权限访问,请联系管理员开通权限");
            return "redirect:/error.htm";
        }
    }

    @RequestMapping("/nopermission.htm")
    public String nopermission(ModelMap modelMap){
        modelMap.addAttribute("msg","无权限，请联系管理员");
        return "/nopermission";
    }

    @RequestMapping(value = "/getOpMap.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getOpMap(@RequestParam Long errorId){
        UserDO userDO = UserUtil.getUser();
        LinkedHashMap map = new LinkedHashMap();
        if(userDO.getRole().equals(RoleEnum.developer.getCode())){
            map = operationAO.getDevErrorOperationSignal(errorId,userDO.getUserId());
        }
        if(userDO.getRole().equals(RoleEnum.clerk.getCode())){
            map = operationAO.getBusErrorOperationSignal(errorId,userDO.getUserId());
        }
        return map;
    }
}
