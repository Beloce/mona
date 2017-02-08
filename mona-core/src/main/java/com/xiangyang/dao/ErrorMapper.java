package com.xiangyang.dao;

import com.xiangyang.model.ErrorDO;
import com.xiangyang.query.ErrorQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for Error.
 */
public interface ErrorMapper {
    /**
     * query count by query condition.
     */
    int countByQuery(ErrorQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(ErrorQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(ErrorDO record);

    /**
     * insert selective.
     */
    int insertSelective(ErrorDO record);

    /**
     * select by query condition.
     */
    List<ErrorDO> selectByQuery(ErrorQuery query);

    /**
     * select by primary key.
     */
    ErrorDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") ErrorDO record, @Param("query") ErrorQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") ErrorDO record, @Param("query") ErrorQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ErrorDO record);
}