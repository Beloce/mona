package com.xiangyang.dao;

import com.xiangyang.model.QuestionShowDO;
import com.xiangyang.query.QuestionShowQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for QuestionShow.
 */
public interface QuestionShowMapper {
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
    int insertSelective(QuestionShowDO record);

    /**
     * select by query condition.
     */
    List<QuestionShowDO> selectByQuery(QuestionShowQuery query);

    /**
     * select by primary key.
     */
    QuestionShowDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") QuestionShowDO record, @Param("query") QuestionShowQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") QuestionShowDO record, @Param("query") QuestionShowQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(QuestionShowDO record);
}