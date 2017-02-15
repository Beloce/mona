package com.xiangyang.manager;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.ProjectDepartmentDO;
import com.xiangyang.query.ProjectDepartmentQuery;

import java.util.List;


/**
 * Manager for ProjectDepartment.
 */
public interface ProjectDepartmentManager {
    /**
     * query count by query condition.
     */
    int countByQuery(ProjectDepartmentQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(ProjectDepartmentQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(ProjectDepartmentDO record);

    /**
     * insert selective.
     */
    long insertSelective(ProjectDepartmentDO record);

    /**
     * select by query condition.
     */
    List<ProjectDepartmentDO> selectByQuery(ProjectDepartmentQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<ProjectDepartmentDO> selectByQueryWithPage(ProjectDepartmentQuery query);

    /**
     * select by primary key.
     */
    ProjectDepartmentDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( ProjectDepartmentDO record,  ProjectDepartmentQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(ProjectDepartmentDO record, ProjectDepartmentQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ProjectDepartmentDO record);
}