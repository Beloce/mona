package com.xiangyang.dao;

import com.xiangyang.model.ProjectDO;
import com.xiangyang.query.ProjectQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for Project.
 */
public interface ProjectMapper {
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
    int insertSelective(ProjectDO record);

    /**
     * select by query condition.
     */
    List<ProjectDO> selectByQuery(ProjectQuery query);

    /**
     * select by primary key.
     */
    ProjectDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") ProjectDO record, @Param("query") ProjectQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") ProjectDO record, @Param("query") ProjectQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ProjectDO record);
}