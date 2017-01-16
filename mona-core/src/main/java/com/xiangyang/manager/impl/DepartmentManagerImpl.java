package com.xiangyang.manager.impl;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.DepartmentDO;
import com.xiangyang.query.DepartmentQuery;
import com.xiangyang.dao.ext.DepartmentExtMapper;
import com.xiangyang.manager.DepartmentManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for Department.
 */

@Component
public class DepartmentManagerImpl implements DepartmentManager{
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    
    @Autowired
    protected DepartmentExtMapper departmentExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(DepartmentQuery query){
        return departmentExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(DepartmentQuery query){
        return departmentExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(DepartmentDO record){
        return departmentExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(DepartmentDO record){
        return departmentExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<DepartmentDO> selectByQuery(DepartmentQuery query){
        return departmentExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<DepartmentDO> selectByQueryWithPage(DepartmentQuery query) {
        PageResult<DepartmentDO> result = new PageResult<DepartmentDO>();
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
    public DepartmentDO selectByPrimaryKey(Long id){
        return departmentExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( DepartmentDO record,  DepartmentQuery query){
        return departmentExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( DepartmentDO record,  DepartmentQuery query){

        return departmentExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(DepartmentDO record){
        return departmentExtMapper.updateByPrimaryKeySelective(record);
    }
}