package com.xiangyang.controller.error;

import com.xiangyang.AO.ProductAO;
import com.xiangyang.BizResult;
import com.xiangyang.enums.error.ErrorTypeEnum;
import com.xiangyang.form.error.ErrorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by peiji on 2017/1/31.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    @Autowired
    ProductAO productAO;

    @RequestMapping("/createError.htm")
    public String createError(ModelMap modelMap){

        modelMap.addAttribute("productList",productAO.queryAllProductList().getResult());
        modelMap.addAttribute("errorTypeMap", ErrorTypeEnum.getErrorTypeList());//问题类型枚举Map
        return "/error/mobileCreateError";
    }
    @RequestMapping("/doAddError.json")
    @ResponseBody
    public Object doAddError(ErrorForm errorForm){
        BizResult bizResult = new BizResult();
        if(errorForm ==null){
            bizResult.setSuccess(false);
        }


        return bizResult;
    }

}
