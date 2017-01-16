package com.xiangyang.controller.user;

import com.xiangyang.AO.UserAO;
import com.xiangyang.AO.VerifyAO;
import com.xiangyang.BizResult;
import com.xiangyang.form.UserInfoForm;
import com.xiangyang.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by xiangyang on 16/10/17.
 */

@RequestMapping(value = "/user")
@Controller
public class UserController {
    @Autowired
    VerifyAO verifyAO;

    @Autowired
    UserAO userAO;

    @RequestMapping("/getuser")
    public String getAllUser(ModelMap model){
        return "user/userProfile";
    }

    /**
     * 用户编辑自己的用户信息的返回信息
     * @param modelMap
     * @return
     */
    @RequestMapping("/edit/userInfoEdit")
    public String userInfoEdit(ModelMap modelMap, HttpSession session){
        UserInfoForm userInfoForm = UserUtil.getUserInfoFormBySession(session);
        if(userInfoForm!=null && !StringUtils.isEmpty(userInfoForm.getEmail())){
            BizResult bizResult = new BizResult();
            bizResult = userAO.getUserInfoByEmail(userInfoForm.getEmail());
            if(bizResult.isSuccess()){
                modelMap.addAttribute("userInfo",bizResult.getResult());
            }
        }
        return "user/edit/userInfoEdit";
    }

    /**
     * 保存用户提交的表单信息
     * @param userInfoForm
     * @param modelMap
     * @param session
     * @return
     */
    @RequestMapping("/edit/userInfoUpdate")
    public String userInfoUpdate(UserInfoForm userInfoForm,ModelMap modelMap, HttpSession session){
        UserInfoForm uif= UserUtil.getUserInfoFormBySession(session);
        if(userInfoForm != null && !StringUtils.isEmpty(userInfoForm.getEmail()) && userInfoForm.getEmail().equals(uif.getEmail())){
            userAO.updateUserInfoByUserInfoForm(userInfoForm);
        }
        return "redirect:/user/edit/userInfoEdit.htm";
    }

}
