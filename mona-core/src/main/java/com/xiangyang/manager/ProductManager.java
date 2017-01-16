package com.xiangyang.manager;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.ProductDO;
import com.xiangyang.query.ProductQuery;

import java.util.List;


/**
 * Manager for Product.
 */
public interface ProductManager {
    /**
     * query count by query condition.
     */
    int countByQuery(ProductQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(ProductQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(ProductDO record);

    /**
     * insert selective.
     */
    long insertSelective(ProductDO record);

    /**
     * select by query condition.
     */
    List<ProductDO> selectByQuery(ProductQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<ProductDO> selectByQueryWithPage(ProductQuery query);

    /**
     * select by primary key.
     */
    ProductDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( ProductDO record,  ProductQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(ProductDO record, ProductQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ProductDO record);
}