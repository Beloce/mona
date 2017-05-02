package com.xiangyang.controller.error;

import com.xiangyang.AO.ErrorAO;
import com.xiangyang.AO.ErrorRecordAO;
import com.xiangyang.AO.ProductAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.ErrorRecordVO;
import com.xiangyang.VO.ErrorVO;
import com.xiangyang.contants.MobilePageContants;
import com.xiangyang.dto.ErrorInfoDTO;
import com.xiangyang.enums.error.*;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    @Autowired
    ErrorRecordAO errorRecordAO;

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
        errorStatusList.add(ErrorStatusEnum.CREATED.getCode());
        errorStatusList.add(ErrorStatusEnum.CONFIRMED.getCode());
        errorStatusList.add(ErrorStatusEnum.VALIDATED.getCode());
        errorStatusList.add(ErrorStatusEnum.PROCESSED.getCode());
        queryErrorForm.setStatus(errorStatusList);
        //查詢操作
        List<ErrorVO> myErrorDOList = errorAO.queryBussinessErrorListByUserDO(userDO);
        BizResult<List<ErrorVO>> allErrorResult = errorAO.queryBussinessErrorList(queryErrorForm);
        if(!allErrorResult.isSuccess()){
            modelMap.addAttribute("msg","系统异常");
            modelMap.addAttribute("redirectUrl", WebUtil.getLastUrlFromReferer(request));
            return "error";
        }
        modelMap.addAttribute("myErrorList",myErrorDOList);
        modelMap.addAttribute("allErrorList",allErrorResult.getResult());
        modelMap.addAttribute("allErrorForm",queryErrorForm);
        modelMap.addAttribute("TimeUtils",new TimeUtils());
        modelMap.addAttribute("productList",productAO.queryAllProductList().getResult());
        return "/error/businessErrorList";
    }

    /**
     * 错误详情页
     * @param errorId
     * @param modelMap
     * @return
     */
    @RequestMapping("/detail.htm")
    public String detail(@RequestParam Long errorId, ModelMap modelMap){
        if(errorId == null){
            return "/error";
        }
        ErrorVO errorVO=errorAO.findErrorVOById(errorId);
        List<ErrorRecordVO> errorRecordVOs = errorRecordAO.queryErrorRecordList(errorId);
        int operateSignal = 0;
        modelMap.addAttribute("errorVO",errorVO);
        modelMap.addAttribute("errorRecordVOs",errorRecordVOs);
        return "/error/detail";
    }

    /**
     * 获取解决方案map
     * @return
     */
    @RequestMapping("/getResolveType.json")
    @ResponseBody
    public Object getResolveType(){
        LinkedHashMap<String,String> map = ResolveTypeEnum.getCodeAndDescMap();
        return map;
    }

    /**
     * 获取解决方案map
     * @return
     */
    @RequestMapping("/getRespType.json")
    @ResponseBody
    public Object getRespType(){
        LinkedHashMap<String,String> map = ResponsibilityEnum.getCodeAndDescMap();
        return map;
    }
}
