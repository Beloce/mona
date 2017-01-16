package com.xiangyang.manager.impl;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.ProductDO;
import com.xiangyang.query.ProductQuery;
import com.xiangyang.dao.ext.ProductExtMapper;
import com.xiangyang.manager.ProductManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for Product.
 */

@Component
public class ProductManagerImpl implements ProductManager{
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    
    @Autowired
    protected ProductExtMapper productExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(ProductQuery query){
        return productExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(ProductQuery query){
        return productExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(ProductDO record){
        return productExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(ProductDO record){
        return productExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<ProductDO> selectByQuery(ProductQuery query){
        return productExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<ProductDO> selectByQueryWithPage(ProductQuery query) {
        PageResult<ProductDO> result = new PageResult<ProductDO>();
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
    public ProductDO selectByPrimaryKey(Long id){
        return productExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( ProductDO record,  ProductQuery query){
        return productExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( ProductDO record,  ProductQuery query){

        return productExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(ProductDO record){
        return productExtMapper.updateByPrimaryKeySelective(record);
    }
}