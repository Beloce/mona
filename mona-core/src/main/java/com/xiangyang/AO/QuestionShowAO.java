package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.VO.QuestionShowVO;
import com.xiangyang.form.product.AddProductForm;
import com.xiangyang.form.qa.QueryQuestionForm;
import com.xiangyang.form.question.AddQuestionForm;
import com.xiangyang.model.QuestionShowDO;

import java.util.List;

/**
 * Created by xiangyang on 17/1/16.
 */
public interface QuestionShowAO {
    /**
     * 获取、查询问题列表
     * @param queryQuestionForm 问题查询条件
     * @return
     */
    List<QuestionShowVO> queryQuestionList(QueryQuestionForm queryQuestionForm);


    /**
     * 添加常见问题展示
     * @param addQuestionForm
     * @return
     */
    BizResult addQuestionAndShow(AddQuestionForm addQuestionForm);




}
