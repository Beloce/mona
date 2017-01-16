package com.xiangyang.controller;

import com.xiangyang.AO.UserAO;
import com.xiangyang.BizResult;
import com.xiangyang.form.UserInfoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String center(HttpServletRequest request, ModelMap modelMap){
        BizResult bizResult = new BizResult();
        if(request.getSession().getAttribute("userInfo")!=null){
            UserInfoForm userInfoForm = (UserInfoForm) request.getSession().getAttribute("userInfo");
            bizResult = userAO.getUserInfoByEmail(userInfoForm.getEmail());//请求用户的详细信息
            if(bizResult.isSuccess()){
                modelMap.addAttribute("result",bizResult.getResult());
                return "center";
            }else{
                bizResult.setMsg("在线超时");
                bizResult.setSuccess(false);
                modelMap.addAttribute("result",bizResult);
                return "redirect:/verify/login.htm";
            }
        }else{
            bizResult.setMsg("请先登录");
            bizResult.setSuccess(false);
            modelMap.addAttribute("result",bizResult);
            return "redirect:/verify/login.htm";
        }
    }
}
