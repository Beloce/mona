package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.VO.ProductVO;
import com.xiangyang.form.product.AddProductForm;
import com.xiangyang.form.product.DeleteProductForm;
import com.xiangyang.form.product.UpdateProductForm;
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

    BizResult<List<ProductVO>>  queryAllProductVOList();

    BizResult<ProductDO> queryProductDOById(Long productId);

    ProductVO queryProductVOById(Long productId);

    boolean updateProductDO(UpdateProductForm updateProductForm);

    BizResult<ProductDO> addProduct(AddProductForm addProductForm);

    List<Long> findProductIdsByTeamIds(List<Long> teamIds);

    Long queryTeamIdByProductId(Long productId);

    BizResult deleteProduct(DeleteProductForm deleteProductForm);
}
