package com.xiangyang.dao;

import com.xiangyang.model.ProductDO;
import com.xiangyang.query.ProductQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for Product.
 */
public interface ProductMapper {
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
    int insertSelective(ProductDO record);

    /**
     * select by query condition.
     */
    List<ProductDO> selectByQuery(ProductQuery query);

    /**
     * select by primary key.
     */
    ProductDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") ProductDO record, @Param("query") ProductQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") ProductDO record, @Param("query") ProductQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ProductDO record);
}