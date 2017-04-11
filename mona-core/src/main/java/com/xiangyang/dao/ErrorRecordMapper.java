package com.xiangyang.dao;

import com.xiangyang.model.ErrorRecordDO;
import com.xiangyang.query.ErrorRecordQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for ErrorRecord.
 */
public interface ErrorRecordMapper {
    /**
     * query count by query condition.
     */
    int countByQuery(ErrorRecordQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(ErrorRecordQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(ErrorRecordDO record);

    /**
     * insert selective.
     */
    int insertSelective(ErrorRecordDO record);

    /**
     * select by query condition.
     */
    List<ErrorRecordDO> selectByQuery(ErrorRecordQuery query);

    /**
     * select by primary key.
     */
    ErrorRecordDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") ErrorRecordDO record, @Param("query") ErrorRecordQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") ErrorRecordDO record, @Param("query") ErrorRecordQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ErrorRecordDO record);
}