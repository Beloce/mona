package com.xiangyang.AO.impl;

import com.xiangyang.AO.QuestionShowAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.QuestionShowVO;
import com.xiangyang.enums.IsDeletedEnum;
import com.xiangyang.enums.questionshow.QsStatusEnum;
import com.xiangyang.form.qa.QueryQuestionForm;
import com.xiangyang.form.question.AddQuestionForm;
import com.xiangyang.manager.ProductManager;
import com.xiangyang.manager.QuestionShowManager;
import com.xiangyang.manager.UserManager;
import com.xiangyang.model.QuestionShowDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.query.QuestionShowQuery;
import com.xiangyang.util.TimeUtils;
import com.xiangyang.util.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangyang on 17/1/16.
 */
@Service
public class QuestionShowAOImpl implements QuestionShowAO {
    @Autowired
    QuestionShowManager questionShowManager;

    @Autowired
    ProductManager productManager;

    @Autowired
    UserManager userManager;

    @Override
    public List<QuestionShowVO> queryQuestionList(QueryQuestionForm queryQuestionForm) {
        QuestionShowQuery questionShowQuery = new QuestionShowQuery();
        questionShowQuery.createCriteria().andStatusEqualTo(QsStatusEnum.using.getCode());
        questionShowQuery.setOrderByClause("question_id desc");

        List<QuestionShowDO> questionShowDOs = questionShowManager.selectByQuery(questionShowQuery);
        return questionDOs2VOs(questionShowDOs);
    }

    @Override
    public BizResult addQuestionAndShow(AddQuestionForm addQuestionForm) {
        BizResult bizResult = new BizResult();
        if(addQuestionForm == null || StringUtils.isBlank(addQuestionForm.getQuestionDesc()) || StringUtils.isBlank(addQuestionForm.getContent())
                || addQuestionForm.getProductId() == null || addQuestionForm.getQuestionTitle() == null){
            bizResult.setSuccess(false);
            bizResult.setMsg("参数为空");
            return bizResult;
        }
        UserDO userDO = UserUtil.getUser();
        QuestionShowDO questionShowDO = new QuestionShowDO();
        questionShowDO.setAuthorId(userDO.getUserId());
        questionShowDO.setDescription(addQuestionForm.getQuestionDesc());
        questionShowDO.setTitle(addQuestionForm.getQuestionTitle());
        questionShowDO.setProductId(addQuestionForm.getProductId());
        questionShowDO.setContent(addQuestionForm.getContent());
        questionShowDO.setStatus(QsStatusEnum.using.getCode());
        questionShowManager.insertSelective(questionShowDO);
        bizResult.setSuccess(true);
        return bizResult;
    }

    private QuestionShowVO questionDO2VO(QuestionShowDO questionShowDO){
        QuestionShowVO questionShowVO = new QuestionShowVO();
        if(questionShowDO == null){
            return questionShowVO;
        }
        BeanUtils.copyProperties(questionShowDO,questionShowVO);
        questionShowVO.setProductName(productManager.selectByPrimaryKey(questionShowDO.getProductId()).getProductName());
        questionShowVO.setAuthorName(userManager.selectByPrimaryKey(questionShowDO.getAuthorId()).getFlowerName());
        questionShowVO.setGmtCreateStr(TimeUtils.DateToStr(questionShowDO.getGmtCreate(),TimeUtils.YYYY_MM_DD));

        return questionShowVO;
    }

    private List<QuestionShowVO> questionDOs2VOs(List<QuestionShowDO> questionShowDOs){
        List<QuestionShowVO> questionShowVOs = new ArrayList<>();
        if(questionShowDOs == null){
            return questionShowVOs;
        }
        for(QuestionShowDO questionShowDO : questionShowDOs){
            QuestionShowVO questionShowcVO =  questionDO2VO(questionShowDO);
            questionShowVOs.add(questionShowcVO);
        }
        return questionShowVOs;
    }
}
