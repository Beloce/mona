package com.xiangyang.manager.impl;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.QuestionShowDO;
import com.xiangyang.query.QuestionShowQuery;
import com.xiangyang.dao.ext.QuestionShowExtMapper;
import com.xiangyang.manager.QuestionShowManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for QuestionShow.
 */

@Component
public class QuestionShowManagerImpl implements QuestionShowManager{
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    
    @Autowired
    protected QuestionShowExtMapper questionShowExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(QuestionShowQuery query){
        return questionShowExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(QuestionShowQuery query){
        return questionShowExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(QuestionShowDO record){
        return questionShowExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(QuestionShowDO record){
        return questionShowExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<QuestionShowDO> selectByQuery(QuestionShowQuery query){
        return questionShowExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<QuestionShowDO> selectByQueryWithPage(QuestionShowQuery query) {
        PageResult<QuestionShowDO> result = new PageResult<QuestionShowDO>();
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
    public QuestionShowDO selectByPrimaryKey(Long id){
        return questionShowExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( QuestionShowDO record,  QuestionShowQuery query){
        return questionShowExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( QuestionShowDO record,  QuestionShowQuery query){

        return questionShowExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(QuestionShowDO record){
        return questionShowExtMapper.updateByPrimaryKeySelective(record);
    }
}