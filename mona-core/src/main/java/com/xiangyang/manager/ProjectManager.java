package com.xiangyang.manager;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.ProjectDO;
import com.xiangyang.query.ProjectQuery;

import java.util.List;


/**
 * Manager for Project.
 */
public interface ProjectManager {
    /**
     * query count by query condition.
     */
    int countByQuery(ProjectQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(ProjectQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(ProjectDO record);

    /**
     * insert selective.
     */
    long insertSelective(ProjectDO record);

    /**
     * select by query condition.
     */
    List<ProjectDO> selectByQuery(ProjectQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<ProjectDO> selectByQueryWithPage(ProjectQuery query);

    /**
     * select by primary key.
     */
    ProjectDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( ProjectDO record,  ProjectQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(ProjectDO record, ProjectQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ProjectDO record);
}