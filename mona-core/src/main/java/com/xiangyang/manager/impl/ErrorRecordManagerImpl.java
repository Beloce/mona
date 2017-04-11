package com.xiangyang.manager.impl;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.ErrorRecordDO;
import com.xiangyang.query.ErrorRecordQuery;
import com.xiangyang.dao.ext.ErrorRecordExtMapper;
import com.xiangyang.manager.ErrorRecordManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ErrorRecord.
 */

@Component
public class ErrorRecordManagerImpl implements ErrorRecordManager{
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    
    @Autowired
    protected ErrorRecordExtMapper errorRecordExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(ErrorRecordQuery query){
        return errorRecordExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(ErrorRecordQuery query){
        return errorRecordExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(ErrorRecordDO record){
        return errorRecordExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(ErrorRecordDO record){
        return errorRecordExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<ErrorRecordDO> selectByQuery(ErrorRecordQuery query){
        return errorRecordExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<ErrorRecordDO> selectByQueryWithPage(ErrorRecordQuery query) {
        PageResult<ErrorRecordDO> result = new PageResult<ErrorRecordDO>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    @Override
    public ErrorRecordDO selectByPrimaryKey(Long id){
        return errorRecordExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( ErrorRecordDO record,  ErrorRecordQuery query){
        return errorRecordExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( ErrorRecordDO record,  ErrorRecordQuery query){

        return errorRecordExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(ErrorRecordDO record){
        return errorRecordExtMapper.updateByPrimaryKeySelective(record);
    }
}