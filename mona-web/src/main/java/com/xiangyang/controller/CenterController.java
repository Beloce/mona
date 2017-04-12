package com.xiangyang.controller;

import com.xiangyang.AO.UserAO;
import com.xiangyang.BizResult;
import com.xiangyang.util.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by xiangyang on 16/11/1.
 */
@RequestMapping(value = "/")
@Controller
public class CenterController {
    @Autowired
    UserAO userAO;

    /**
     * 首页转跳
     * @return
     */
    @RequestMapping(value = "/jump")
    public String showWelcomePage(){
        return "redirect:/verify/login.htm";
    }

    /**
     * 进入中心控制平台
     * @return
     */
    @RequestMapping(value = "/center")
    public String center(ModelMap modelMap, HttpServletRequest request){
        BizResult bizResult = new BizResult();
        bizResult = userAO.getUserInfoByEmail(UserUtil.getUser().getEmail());
        modelMap.addAttribute("result",bizResult.getResult());
        return "center";
    }

    @RequestMapping(value = "/index.htm")
    public String index(ModelMap modelMap){
        return "index";
    }
}
