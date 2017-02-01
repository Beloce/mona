package com.xiangyang.manager.impl;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.query.ErrorQuery;
import com.xiangyang.dao.ext.ErrorExtMapper;
import com.xiangyang.manager.ErrorManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for Error.
 */

@Component
public class ErrorManagerImpl implements ErrorManager{
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    
    @Autowired
    protected ErrorExtMapper errorExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(ErrorQuery query){
        return errorExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(ErrorQuery query){
        return errorExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(ErrorDO record){
        return errorExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(ErrorDO record){
        return errorExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<ErrorDO> selectByQuery(ErrorQuery query){
        return errorExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<ErrorDO> selectByQueryWithPage(ErrorQuery query) {
        PageResult<ErrorDO> result = new PageResult<ErrorDO>();
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
    public ErrorDO selectByPrimaryKey(Long id){
        return errorExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( ErrorDO record,  ErrorQuery query){
        return errorExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( ErrorDO record,  ErrorQuery query){

        return errorExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(ErrorDO record){
        return errorExtMapper.updateByPrimaryKeySelective(record);
    }
}