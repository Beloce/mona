package com.xiangyang.manager.impl;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.TeamUserDO;
import com.xiangyang.query.TeamUserQuery;
import com.xiangyang.dao.ext.TeamUserExtMapper;
import com.xiangyang.manager.TeamUserManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for TeamUser.
 */

@Component
public class TeamUserManagerImpl implements TeamUserManager{
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    
    @Autowired
    protected TeamUserExtMapper teamUserExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(TeamUserQuery query){
        return teamUserExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(TeamUserQuery query){
        return teamUserExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(TeamUserDO record){
        return teamUserExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(TeamUserDO record){
        return teamUserExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<TeamUserDO> selectByQuery(TeamUserQuery query){
        return teamUserExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<TeamUserDO> selectByQueryWithPage(TeamUserQuery query) {
        PageResult<TeamUserDO> result = new PageResult<TeamUserDO>();
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
    public TeamUserDO selectByPrimaryKey(Long id){
        return teamUserExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( TeamUserDO record,  TeamUserQuery query){
        return teamUserExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( TeamUserDO record,  TeamUserQuery query){

        return teamUserExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(TeamUserDO record){
        return teamUserExtMapper.updateByPrimaryKeySelective(record);
    }
}