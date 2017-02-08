package com.xiangyang.manager;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.QuestionAnsDO;
import com.xiangyang.query.QuestionAnsQuery;

import java.util.List;


/**
 * Manager for QuestionAns.
 */
public interface QuestionAnsManager {
    /**
     * query count by query condition.
     */
    int countByQuery(QuestionAnsQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(QuestionAnsQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(QuestionAnsDO record);

    /**
     * insert selective.
     */
    long insertSelective(QuestionAnsDO record);

    /**
     * select by query condition.
     */
    List<QuestionAnsDO> selectByQuery(QuestionAnsQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<QuestionAnsDO> selectByQueryWithPage(QuestionAnsQuery query);

    /**
     * select by primary key.
     */
    QuestionAnsDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( QuestionAnsDO record,  QuestionAnsQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(QuestionAnsDO record, QuestionAnsQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(QuestionAnsDO record);
}