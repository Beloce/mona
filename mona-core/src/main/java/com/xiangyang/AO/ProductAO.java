package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.model.ProductDO;

import java.util.List;

/**
 * Created by xiangyang on 17/1/18.
 */
public interface ProductAO {

    /**
     * 获取所有的常见问题列表
     * @return
     */
    BizResult<List<ProductDO>>  queryAllProductList();
}
