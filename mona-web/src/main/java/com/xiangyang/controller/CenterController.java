package com.xiangyang.controller;

import com.xiangyang.AO.ErrorAO;
import com.xiangyang.AO.UserAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.ErrorVO;
import com.xiangyang.model.UserDO;
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
import java.util.List;


/**
 * Created by xiangyang on 16/11/1.
 */
@RequestMapping(value = "/")
@Controller
public class CenterController {
    @Autowired
    UserAO userAO;

    @Autowired
    ErrorAO errorAO;

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
        UserDO userDO = UserUtil.getUser();
        List<ErrorVO> errorVOs = errorAO.queryBussinessErrorListByUserDO(userDO);
        int myWaitDo = errorVOs.size(); //我的待办数量
        int allWaitDo = errorAO.countAllWaitToSolveError(); //所有的待办数量
        int todayNew = errorAO.countTodayNewError(); //今日新增的数量
        int todayDone = errorAO.countTodayDoneError();//今日解决

        modelMap.addAttribute("myWait",myWaitDo);
        modelMap.addAttribute("allWait",allWaitDo);
        modelMap.addAttribute("todayNew",todayNew);
        modelMap.addAttribute("todayDone",todayDone);

        return "index";
    }
}
