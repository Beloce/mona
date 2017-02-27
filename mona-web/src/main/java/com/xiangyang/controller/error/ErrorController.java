package com.xiangyang.controller.error;

import com.xiangyang.AO.ErrorAO;
import com.xiangyang.AO.ProductAO;
import com.xiangyang.BizResult;
import com.xiangyang.contants.MobilePageContants;
import com.xiangyang.dto.ErrorInfoDTO;
import com.xiangyang.enums.error.ErrorSourceEnum;
import com.xiangyang.enums.error.ErrorStatusEnum;
import com.xiangyang.enums.error.ErrorTypeEnum;
import com.xiangyang.form.error.ErrorForm;
import com.xiangyang.form.error.QueryErrorForm;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.util.TimeUtils;
import com.xiangyang.util.UserUtil;
import com.xiangyang.util.WebUtil;
import org.eclipse.jetty.server.Authentication;
import org.omg.CORBA.TIMEOUT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    /**
     * 线上业务异常页面路由,默认未结束的的异常
     * @param modelMap
     * @return
     */
    @RequestMapping("/businessErrorList.htm")
    public String errorList(ModelMap modelMap,HttpServletRequest request){
        UserDO userDO = UserUtil.getUser();
        QueryErrorForm queryErrorForm = new QueryErrorForm();
        queryErrorForm.setPageNo(1);
        queryErrorForm.setPageSize(5);
        /*
        这边系统写死默认查询到的所有异常为待解决状态
         */
        queryErrorForm.setErrorSource(ErrorSourceEnum.Business.getCode());
        List<Integer> errorStatusList = new ArrayList<Integer>();
        errorStatusList.add(ErrorStatusEnum.Create.getCode());
        errorStatusList.add(ErrorStatusEnum.Confirm.getCode());
        errorStatusList.add(ErrorStatusEnum.Evaluate.getCode());
        errorStatusList.add(ErrorStatusEnum.Processed.getCode());
        queryErrorForm.setStatus(errorStatusList);
        //查詢操作
        List<ErrorDO> myErrorDOList = errorAO.queryBussinessErrorListByUserDO(userDO);
        BizResult<List<ErrorInfoDTO>> allErrorResult = errorAO.queryBussinessErrorList(queryErrorForm);
        if(!allErrorResult.isSuccess()){
            modelMap.addAttribute("msg","系统异常");
            modelMap.addAttribute("redirectUrl", WebUtil.getLastUrlFromReferer(request));
            return "error";
        }
        modelMap.addAttribute("allErrorList",allErrorResult.getResult());
        modelMap.addAttribute("allErrorForm",queryErrorForm);
        modelMap.addAttribute ("TimeUtils",new TimeUtils());
        return "/error/businessErrorList";
    }
}
