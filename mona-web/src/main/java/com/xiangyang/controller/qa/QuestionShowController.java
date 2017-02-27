package com.xiangyang.controller.qa;

import com.xiangyang.AO.ProductAO;
import com.xiangyang.AO.QuestionShowAO;
import com.xiangyang.BizResult;
import com.xiangyang.contants.MobilePageContants;
import com.xiangyang.enums.QuestionLevelEnum;
import com.xiangyang.form.qa.QueryQuestionForm;
import com.xiangyang.model.ProductDO;
import com.xiangyang.model.QuestionShowDO;
import com.xiangyang.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangyang on 17/1/16.
 */
@Controller
@RequestMapping("/qa")
public class QuestionShowController {
    @Autowired
    QuestionShowAO questionShowAO;

    @Autowired
    ProductAO productAO;


    /**
     * 显示常见问题列表
     * @param queryQuestionForm
     * @param modelMap
     * @return
     */
    @RequestMapping("/questionList.htm")
    public String questionList(QueryQuestionForm queryQuestionForm, ModelMap modelMap){
        List<QuestionShowDO> questionShowDOs = questionShowAO.queryQuestionList(queryQuestionForm);


        return "/qa/questionList";
    }

    /**
     * 添加常见问题
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("/addQuestion.htm")
    public String addQuestion(ModelMap modelMap, HttpServletRequest request){
        BizResult<List<ProductDO>> productResult = productAO.queryAllProductList();
        if (!productResult.isSuccess()){
            modelMap.addAttribute("redirectUrl", WebUtil.getLastUrlFromReferer(request));
            modelMap.addAttribute("msg","产品读取错误");
            return "/error";
        }
        modelMap.addAttribute("productList",productResult.getResult());
        modelMap.addAttribute("questionLevelList", QuestionLevelEnum.getQuestionLevelList());
        return "/qa/addQuestion";
    }
    /**
     * 添加常见问题ajax请求
     * @return
     */
    @RequestMapping("/doAddQuestion.json")
    public Object doAddQuestion(){
        BizResult bizResult = new BizResult();

        return bizResult;
    }

}
