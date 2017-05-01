package com.xiangyang.controller.error;

import com.xiangyang.AO.ErrorAO;
import com.xiangyang.AO.ErrorRecordAO;
import com.xiangyang.AO.ProductAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.ErrorRecordVO;
import com.xiangyang.VO.ErrorVO;
import com.xiangyang.contants.MobilePageContants;
import com.xiangyang.enums.error.ErrorTypeEnum;
import com.xiangyang.form.error.ErrorForm;
import com.xiangyang.form.error.QueryErrorForm;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peiji on 2017/2/25.
 */
@Controller
@RequestMapping("/mobileError")
public class MobileErrorController {
    @Autowired
    ProductAO productAO;

    @Autowired
    ErrorAO errorAO;

    @Autowired
    ErrorRecordAO errorRecordAO;

    final Logger logger  =  LoggerFactory.getLogger(this.getClass());
//=============================page1=====================================
    /**
     * H5业务人员创建问题界面路由
     * @param modelMap
     * @return
     */
    @RequestMapping("/mobileCreateError.htm")
    public String createError(ModelMap modelMap){
        modelMap.addAttribute("productList",productAO.queryAllProductList().getResult());
        modelMap.addAttribute("errorTypeMap", ErrorTypeEnum.getErrorTypeList());//问题类型枚举Map
        modelMap.addAttribute("page", MobilePageContants.MOBILE_PAGE_1);
        return "/error/mobile/mobileCreateError";
    }

    /**
     * H5业务人员问题异步提交请求
     * @param errorForm
     * @return
     */
    @RequestMapping(value ="/doAddError.json" , method = RequestMethod.POST)
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

        logger.info("|--------------发布问题成功--------------|\r\n"+errorForm.toString());
        return bizResult;
    }


//=============================page2=====================================
    /**
     * H5业务人员提问列表路由
     * @param modelMap
     * @return
     */
    @RequestMapping("/mobileErrorList.htm" )
    public String mobileErrorList(ModelMap modelMap){
        modelMap.addAttribute("page", MobilePageContants.MOBILE_PAGE_2);
        return "/error/mobile/mobileErrorList";
    }

    /**
     * 通过问题编号获取问题详情
     * @param errorId
     * @param modelMap
     * @return
     */
    @RequestMapping("/detail.htm" )
    public String detail(Long errorId,ModelMap modelMap){
        if(errorId != null){
           ErrorVO errorVO = errorAO.findErrorVOById(errorId);
           List<ErrorRecordVO> errorRecordVOs = errorRecordAO.queryErrorRecordList(errorId);
           modelMap.addAttribute("page", MobilePageContants.MOBILE_PAGE_2);
           modelMap.addAttribute("errorRecordVOs",errorRecordVOs);
           modelMap.addAttribute("errorVO",errorVO);
        }

        return "/error/mobile/detail";
    }
    /**
     * H5业务人员ajax异步获取他的待解决的提问列表
     * @param queryErrorForm
     * @return
     */
    @RequestMapping(value = "/getWaitResolveErrorListAjax.json", method = RequestMethod.GET)
    @ResponseBody
    public Object getWaitResolveErrorListAjax(QueryErrorForm queryErrorForm){
        BizResult bizResult = new BizResult();
        UserDO userDO = UserUtil.getUser();
        if(userDO == null){
            bizResult.setSuccess(false);
            bizResult.setMsg("请登录后操作");
        }
        List<ErrorVO> errorVOs = errorAO.queryBussinessWaitErrorList(userDO,queryErrorForm);
        bizResult.setResult(errorVOs);
        bizResult.setSuccess(true);
        return bizResult;
    }

    /**
     * H5业务人员ajax异步获取他的已结束提问列表
     * @param queryErrorForm
     * @return
     */
    @RequestMapping(value = "/getOverErrorListAjax.json", method = RequestMethod.GET)
    @ResponseBody
    public Object getOverErrorListAjax(QueryErrorForm queryErrorForm){
        BizResult bizResult = new BizResult();
        UserDO userDO = UserUtil.getUser();
        if(userDO == null){
            bizResult.setSuccess(false);
            bizResult.setMsg("请登录后操作");
        }
        List<ErrorVO> errorVOs = errorAO.queryBussinessOverErrorList(userDO,queryErrorForm);
        bizResult.setResult(errorVOs);
        bizResult.setSuccess(true);
        return bizResult;
    }
}
