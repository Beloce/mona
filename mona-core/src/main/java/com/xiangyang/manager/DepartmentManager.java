package com.xiangyang.manager;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.DepartmentDO;
import com.xiangyang.query.DepartmentQuery;

import java.util.List;


/**
 * Manager for Department.
 */
public interface DepartmentManager {
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
    long insertSelective(DepartmentDO record);

    /**
     * select by query condition.
     */
    List<DepartmentDO> selectByQuery(DepartmentQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<DepartmentDO> selectByQueryWithPage(DepartmentQuery query);

    /**
     * select by primary key.
     */
    DepartmentDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( DepartmentDO record,  DepartmentQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(DepartmentDO record, DepartmentQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(DepartmentDO record);
}