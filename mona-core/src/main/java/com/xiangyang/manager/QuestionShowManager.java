package com.xiangyang.manager;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.QuestionShowDO;
import com.xiangyang.query.QuestionShowQuery;

import java.util.List;


/**
 * Manager for QuestionShow.
 */
public interface QuestionShowManager {
    /**
     * query count by query condition.
     */
    int countByQuery(QuestionShowQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(QuestionShowQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(QuestionShowDO record);

    /**
     * insert selective.
     */
    long insertSelective(QuestionShowDO record);

    /**
     * select by query condition.
     */
    List<QuestionShowDO> selectByQuery(QuestionShowQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<QuestionShowDO> selectByQueryWithPage(QuestionShowQuery query);

    /**
     * select by primary key.
     */
    QuestionShowDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( QuestionShowDO record,  QuestionShowQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(QuestionShowDO record, QuestionShowQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(QuestionShowDO record);
}