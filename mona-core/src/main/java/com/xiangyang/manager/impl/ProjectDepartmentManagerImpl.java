package com.xiangyang.manager.impl;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.ProjectDepartmentDO;
import com.xiangyang.query.ProjectDepartmentQuery;
import com.xiangyang.dao.ext.ProjectDepartmentExtMapper;
import com.xiangyang.manager.ProjectDepartmentManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for ProjectDepartment.
 */

@Component
public class ProjectDepartmentManagerImpl implements ProjectDepartmentManager{
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    
    @Autowired
    protected ProjectDepartmentExtMapper projectDepartmentExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(ProjectDepartmentQuery query){
        return projectDepartmentExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(ProjectDepartmentQuery query){
        return projectDepartmentExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(ProjectDepartmentDO record){
        return projectDepartmentExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(ProjectDepartmentDO record){
        return projectDepartmentExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<ProjectDepartmentDO> selectByQuery(ProjectDepartmentQuery query){
        return projectDepartmentExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<ProjectDepartmentDO> selectByQueryWithPage(ProjectDepartmentQuery query) {
        PageResult<ProjectDepartmentDO> result = new PageResult<ProjectDepartmentDO>();
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
    public ProjectDepartmentDO selectByPrimaryKey(Long id){
        return projectDepartmentExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( ProjectDepartmentDO record,  ProjectDepartmentQuery query){
        return projectDepartmentExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( ProjectDepartmentDO record,  ProjectDepartmentQuery query){

        return projectDepartmentExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(ProjectDepartmentDO record){
        return projectDepartmentExtMapper.updateByPrimaryKeySelective(record);
    }
}