package com.xiangyang.dao;

import com.xiangyang.model.DepartmentDO;
import com.xiangyang.query.DepartmentQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for Department.
 */
public interface DepartmentMapper {
    /**
     * query count by query condition.
     */
    int countByQuery(DepartmentQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(DepartmentQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(DepartmentDO record);

    /**
     * insert selective.
     */
    int insertSelective(DepartmentDO record);

    /**
     * select by query condition.
     */
    List<DepartmentDO> selectByQuery(DepartmentQuery query);

    /**
     * select by primary key.
     */
    DepartmentDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") DepartmentDO record, @Param("query") DepartmentQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") DepartmentDO record, @Param("query") DepartmentQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(DepartmentDO record);
}