package com.xiangyang.dao;

import com.xiangyang.model.ProjectDepartmentDO;
import com.xiangyang.query.ProjectDepartmentQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for ProjectDepartment.
 */
public interface ProjectDepartmentMapper {
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
    int insertSelective(ProjectDepartmentDO record);

    /**
     * select by query condition.
     */
    List<ProjectDepartmentDO> selectByQuery(ProjectDepartmentQuery query);

    /**
     * select by primary key.
     */
    ProjectDepartmentDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") ProjectDepartmentDO record, @Param("query") ProjectDepartmentQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") ProjectDepartmentDO record, @Param("query") ProjectDepartmentQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ProjectDepartmentDO record);
}