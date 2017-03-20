package com.xiangyang.manager.impl;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.TeamDO;
import com.xiangyang.query.TeamQuery;
import com.xiangyang.dao.ext.TeamExtMapper;
import com.xiangyang.manager.TeamManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for Team.
 */

@Component
public class TeamManagerImpl implements TeamManager{
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    
    @Autowired
    protected TeamExtMapper teamExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(TeamQuery query){
        return teamExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(TeamQuery query){
        return teamExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(TeamDO record){
        return teamExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(TeamDO record){
        return teamExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<TeamDO> selectByQuery(TeamQuery query){
        return teamExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<TeamDO> selectByQueryWithPage(TeamQuery query) {
        PageResult<TeamDO> result = new PageResult<TeamDO>();
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
    public TeamDO selectByPrimaryKey(Long id){
        return teamExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( TeamDO record,  TeamQuery query){
        return teamExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( TeamDO record,  TeamQuery query){

        return teamExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(TeamDO record){
        return teamExtMapper.updateByPrimaryKeySelective(record);
    }
}