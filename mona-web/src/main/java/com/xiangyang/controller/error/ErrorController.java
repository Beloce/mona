package com.xiangyang.controller.error;

import com.xiangyang.AO.ErrorAO;
import com.xiangyang.AO.ProductAO;
import com.xiangyang.BizResult;
import com.xiangyang.enums.error.ErrorTypeEnum;
import com.xiangyang.form.error.ErrorForm;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.util.UserUtil;
import org.eclipse.jetty.server.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by peiji on 2017/1/31.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    @Autowired
    ProductAO productAO;

    @Autowired
    ErrorAO errorAO;

    final Logger logger  =  LoggerFactory.getLogger(this.getClass());

    /**
     * 业务人员创建问题界面路由
     * @param modelMap
     * @return
     */
    @RequestMapping("/createError.htm")
    public String createError(ModelMap modelMap){
        modelMap.addAttribute("productList",productAO.queryAllProductList().getResult());
        modelMap.addAttribute("errorTypeMap", ErrorTypeEnum.getErrorTypeList());//问题类型枚举Map
        return "/error/mobileCreateError";
    }

    /**
     * 业务人员问题异步提交请求
     * @param errorForm
     * @return
     */
    @RequestMapping("/doAddError.json")
    @ResponseBody
    public Object doAddError(@RequestBody ErrorForm errorForm){
        BizResult bizResult = new BizResult();
        if(errorForm == null){
            bizResult.setSuccess(false);
            logger.info("|-------------发布问题失败，表单为空--------------|");
            return bizResult;
        }
        errorForm.setUserDO(UserUtil.getUser());
        bizResult = errorAO.addNewError(errorForm);
        bizResult.setSuccess(true);

        logger.info("|--------------发布问题成功\r\n"+errorForm.toString()+"--------------|");
        return bizResult;
    }

    @RequestMapping("/businessErrorList.htm")
    public String errorList(ModelMap modelMap){
        UserDO userDO = UserUtil.getUser();
        List<ErrorDO> errorDOList = errorAO.queryBussinessErrorListByUserDO(userDO);
        modelMap.addAttribute("errorList",errorDOList);


        return "/error/businessErrorList";
    }

}
