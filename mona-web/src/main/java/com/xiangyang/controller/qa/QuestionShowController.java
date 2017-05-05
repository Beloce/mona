package com.xiangyang.controller.qa;

import com.xiangyang.AO.ProductAO;
import com.xiangyang.AO.QuestionShowAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.QuestionShowVO;
import com.xiangyang.contants.MobilePageContants;
import com.xiangyang.enums.QuestionLevelEnum;
import com.xiangyang.form.qa.QueryQuestionForm;
import com.xiangyang.form.question.AddQuestionForm;
import com.xiangyang.manager.ErrorManager;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.ProductDO;
import com.xiangyang.model.QuestionShowDO;
import com.xiangyang.util.HtmlGenUtil;
import com.xiangyang.util.ImgUrlUtil;
import com.xiangyang.util.TimeUtils;
import com.xiangyang.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    ErrorManager errorManager;


    /**
     * 显示常见问题列表
     * @param queryQuestionForm
     * @param modelMap
     * @return
     */
    @RequestMapping("/questionList.htm")
    public String questionList(QueryQuestionForm queryQuestionForm, ModelMap modelMap){
        List<QuestionShowVO> questionShowVOs = questionShowAO.queryQuestionList(queryQuestionForm);
        modelMap.addAttribute("questionShowVOs",questionShowVOs);
        return "/qa/questionList";
    }

    /**
     * 添加常见问题
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("/addQuestion.htm")
    public String addQuestion(Long errorId,ModelMap modelMap){
        if(errorId != null)
        {
            ErrorDO errorDO = errorManager.selectByPrimaryKey(errorId);
            String quote = HtmlGenUtil.questionHtmlGen(errorDO.getTitle(), TimeUtils.DateToStr(errorDO.getGmtCreate(),TimeUtils.YYYY_MM_DD),
                    errorDO.getReason(), ImgUrlUtil.parseList(errorDO.getScreenshot()));
            modelMap.addAttribute("quote",quote);
        }
        List<ProductDO> productDOs = productAO.queryAllProductList().getResult();
        modelMap.addAttribute("productList",productDOs);
        return "/qa/addQuestion";
    }

    /**
     * 添加常见问题ajax请求
     * @return
     */
    @RequestMapping(value = "/doAddQuestion.json",method = RequestMethod.POST)
    @ResponseBody
    public Object doAddQuestion(@RequestBody AddQuestionForm addQuestionForm){
        BizResult bizResult = questionShowAO.addQuestionAndShow(addQuestionForm);
        return bizResult;
    }
}
