package com.xiangyang.manager;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.ErrorRecordDO;
import com.xiangyang.query.ErrorRecordQuery;

import java.util.List;


/**
 * Manager for ErrorRecord.
 */
public interface ErrorRecordManager {
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
    long insertSelective(ErrorRecordDO record);

    /**
     * select by query condition.
     */
    List<ErrorRecordDO> selectByQuery(ErrorRecordQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<ErrorRecordDO> selectByQueryWithPage(ErrorRecordQuery query);

    /**
     * select by primary key.
     */
    ErrorRecordDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( ErrorRecordDO record,  ErrorRecordQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(ErrorRecordDO record, ErrorRecordQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ErrorRecordDO record);
}