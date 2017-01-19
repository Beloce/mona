package com.xiangyang.controller.qa;

import com.xiangyang.AO.ProductAO;
import com.xiangyang.AO.QuestionShowAO;
import com.xiangyang.BizResult;
import com.xiangyang.form.qa.QueryQuestionForm;
import com.xiangyang.model.QuestionShowDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<QuestionShowDO> bizResult = questionShowAO.queryQuestionList(queryQuestionForm);


        return "/qa/questionList";
    }
    @RequestMapping("/addQuestion.htm")
    public String addQuestion(ModelMap modelMap){


        return "/qa/addQuestion";
    }
    @RequestMapping("/doAddQuestion.json")
    public Object doAddQuestion(){
        BizResult bizResult = new BizResult();



        return bizResult;
    }
}
