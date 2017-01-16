package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.form.qa.QueryQuestionForm;

/**
 * Created by xiangyang on 17/1/16.
 */
public interface QuestionShowAO {
    /**
     * 获取、查询问题列表
     * @param queryQuestionForm 问题查询条件
     * @return
     */
    BizResult queryQuestionList(QueryQuestionForm queryQuestionForm);




}
