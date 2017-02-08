package com.xiangyang.dao;

import com.xiangyang.model.QuestionAnsDO;
import com.xiangyang.query.QuestionAnsQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for QuestionAns.
 */
public interface QuestionAnsMapper {
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
    int insertSelective(QuestionAnsDO record);

    /**
     * select by query condition.
     */
    List<QuestionAnsDO> selectByQuery(QuestionAnsQuery query);

    /**
     * select by primary key.
     */
    QuestionAnsDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") QuestionAnsDO record, @Param("query") QuestionAnsQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") QuestionAnsDO record, @Param("query") QuestionAnsQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(QuestionAnsDO record);
}