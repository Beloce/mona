package com.xiangyang.manager.impl;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.ProjectDO;
import com.xiangyang.query.ProjectQuery;
import com.xiangyang.dao.ext.ProjectExtMapper;
import com.xiangyang.manager.ProjectManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for Project.
 */

@Component
public class ProjectManagerImpl implements ProjectManager{
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    
    @Autowired
    protected ProjectExtMapper projectExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(ProjectQuery query){
        return projectExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(ProjectQuery query){
        return projectExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(ProjectDO record){
        return projectExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(ProjectDO record){
        return projectExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<ProjectDO> selectByQuery(ProjectQuery query){
        return projectExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<ProjectDO> selectByQueryWithPage(ProjectQuery query) {
        PageResult<ProjectDO> result = new PageResult<ProjectDO>();
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
    public ProjectDO selectByPrimaryKey(Long id){
        return projectExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( ProjectDO record,  ProjectQuery query){
        return projectExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( ProjectDO record,  ProjectQuery query){

        return projectExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(ProjectDO record){
        return projectExtMapper.updateByPrimaryKeySelective(record);
    }
}