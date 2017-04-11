package com.xiangyang.AO.impl;

import com.xiangyang.AO.QuestionShowAO;
import com.xiangyang.BizResult;
import com.xiangyang.enums.IsDeletedEnum;
import com.xiangyang.enums.questionshow.QsStatusEnum;
import com.xiangyang.form.qa.QueryQuestionForm;
import com.xiangyang.manager.QuestionShowManager;
import com.xiangyang.model.QuestionShowDO;
import com.xiangyang.query.QuestionShowQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiangyang on 17/1/16.
 */
@Service
public class QuestionShowAOImpl implements QuestionShowAO {
    @Autowired
    QuestionShowManager questionShowManager;


    @Override
    public List<QuestionShowDO> queryQuestionList(QueryQuestionForm queryQuestionForm) {
        QuestionShowQuery questionShowQuery = new QuestionShowQuery();
        questionShowQuery.createCriteria().andStatusEqualTo(QsStatusEnum.Deleted.getCode());
        return questionShowManager.selectByQuery(questionShowQuery);
    }
}
