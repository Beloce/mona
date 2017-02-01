package com.xiangyang.manager;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.query.ErrorQuery;

import java.util.List;


/**
 * Manager for Error.
 */
public interface ErrorManager {
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
    long insertSelective(ErrorDO record);

    /**
     * select by query condition.
     */
    List<ErrorDO> selectByQuery(ErrorQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<ErrorDO> selectByQueryWithPage(ErrorQuery query);

    /**
     * select by primary key.
     */
    ErrorDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( ErrorDO record,  ErrorQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(ErrorDO record, ErrorQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ErrorDO record);
}