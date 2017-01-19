package com.xiangyang.AO.impl;

import com.xiangyang.AO.ProductAO;
import com.xiangyang.BizResult;
import com.xiangyang.manager.ProductManager;
import com.xiangyang.model.ProductDO;
import com.xiangyang.query.ProductQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by xiangyang on 17/1/18.
 */
public class ProductAOImpl implements ProductAO {
    @Autowired
    ProductManager productManager;

    final Logger logger  =  LoggerFactory.getLogger(this.getClass());

    @Override
    public BizResult<List<ProductDO>> queryAllProductList() {
        BizResult<List<ProductDO>> bizResult = new BizResult<List<ProductDO>>();
        try{
            ProductQuery productQuery = new ProductQuery();
            productQuery.createCriteria().andProductIdIsNotNull();
            List<ProductDO> productDOList = productManager.selectByQuery(productQuery);
            bizResult.setSuccess(true);
            bizResult.setResult(productDOList);
        }catch (Exception e){
            bizResult.setSuccess(false);
            logger.error(e.getMessage());
        }
        return bizResult;
    }
}
