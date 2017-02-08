package com.xiangyang.manager.impl;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.QuestionAnsDO;
import com.xiangyang.query.QuestionAnsQuery;
import com.xiangyang.dao.ext.QuestionAnsExtMapper;
import com.xiangyang.manager.QuestionAnsManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for QuestionAns.
 */

@Component
public class QuestionAnsManagerImpl implements QuestionAnsManager{
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    
    @Autowired
    protected QuestionAnsExtMapper questionAnsExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(QuestionAnsQuery query){
        return questionAnsExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(QuestionAnsQuery query){
        return questionAnsExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(QuestionAnsDO record){
        return questionAnsExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(QuestionAnsDO record){
        return questionAnsExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<QuestionAnsDO> selectByQuery(QuestionAnsQuery query){
        return questionAnsExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<QuestionAnsDO> selectByQueryWithPage(QuestionAnsQuery query) {
        PageResult<QuestionAnsDO> result = new PageResult<QuestionAnsDO>();
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
    public QuestionAnsDO selectByPrimaryKey(Long id){
        return questionAnsExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( QuestionAnsDO record,  QuestionAnsQuery query){
        return questionAnsExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( QuestionAnsDO record,  QuestionAnsQuery query){

        return questionAnsExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(QuestionAnsDO record){
        return questionAnsExtMapper.updateByPrimaryKeySelective(record);
    }
}