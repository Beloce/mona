package com.xiangyang.AO.impl;

import com.xiangyang.AO.ProductAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.ProductVO;
import com.xiangyang.enums.product.ProductEnum;
import com.xiangyang.enums.product.ProductStatusEnum;
import com.xiangyang.form.product.AddProductForm;
import com.xiangyang.form.product.DeleteProductForm;
import com.xiangyang.form.product.UpdateProductForm;
import com.xiangyang.manager.ProductManager;
import com.xiangyang.manager.TeamManager;
import com.xiangyang.model.ProductDO;
import com.xiangyang.model.TeamDO;
import com.xiangyang.query.ProductQuery;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangyang on 17/1/18.
 */
@Service
public class ProductAOImpl implements ProductAO {
    @Autowired
    ProductManager productManager;

    @Autowired
    TeamManager teamManager;

    final Logger logger  =  LoggerFactory.getLogger(this.getClass());


    @Override
    public BizResult<List<ProductDO>> queryAllProductList() {
        BizResult<List<ProductDO>> bizResult = new BizResult<List<ProductDO>>();
        try{
            ProductQuery productQuery = new ProductQuery();
            productQuery.createCriteria().andProductIdIsNotNull().andStatusNotEqualTo(ProductStatusEnum.Deleted.getCode());
            List<ProductDO> productDOList = productManager.selectByQuery(productQuery);
            bizResult.setSuccess(true);
            bizResult.setResult(productDOList);
        }catch (Exception e){
            bizResult.setSuccess(false);
            logger.error(e.getMessage());
        }
        return bizResult;
    }

    @Override
    public BizResult<List<ProductVO>> queryAllProductVOList() {
        BizResult<List<ProductVO>> bizResult = new BizResult<List<ProductVO>>();
        try{
            ProductQuery productQuery = new ProductQuery();
            productQuery.createCriteria().andProductIdIsNotNull().andStatusNotEqualTo(ProductStatusEnum.Deleted.getCode());
            List<ProductDO> productDOList = productManager.selectByQuery(productQuery);
            List<ProductVO> productVOs = new ArrayList<>();
            for(ProductDO productDO : productDOList){
                ProductVO productVO = new ProductVO();
                productVO.setId(productDO.getProductId());
                productVO.setProductDesc(productDO.getProductDesc());
                productVO.setProductName(productDO.getProductName());
                productVO.setTeamId(productDO.getProductId());
                if(productDO.getTeamId() != null){
                    TeamDO teamDO = teamManager.selectByPrimaryKey(productDO.getTeamId());
                    productVO.setTeamName(teamDO.getTeamName());
                }
                productVOs.add(productVO);
            }
            bizResult.setSuccess(true);
            bizResult.setResult(productVOs);
        }catch (Exception e){
            bizResult.setSuccess(false);
            logger.error(e.getMessage());
        }
        return bizResult;
    }

    @Override
    public BizResult<ProductDO> queryProductDOById(Long productId) {
        BizResult<ProductDO> bizResult = new BizResult<>();
        if(productId == null){
            bizResult.setSuccess(false);
            bizResult.setMsg("参数为空");
            return bizResult;
        }
        try {
            ProductDO productDO = productManager.selectByPrimaryKey(productId);
            bizResult.setResult(productDO);
            bizResult.setSuccess(true);
        }catch (Exception e){
            bizResult.setSuccess(false);
            bizResult.setMsg("服务器异常");
            logger.error(e.getMessage());
        }
        return bizResult;
    }

    @Override
    public ProductVO queryProductVOById(Long productId) {
        ProductVO productVO = new ProductVO();
        if(productId == null){
            return productVO;
        }
        ProductDO productDO = productManager.selectByPrimaryKey(productId);
        BeanUtils.copyProperties(productDO,productVO);
        if(productDO.getTeamId()!=null){
            TeamDO teamDO = teamManager.selectByPrimaryKey(productDO.getTeamId());
            productVO.setTeamName(teamDO.getTeamName());
        }
        return productVO;
    }

    @Override
    public boolean updateProductDO(UpdateProductForm updateProductForm) {
        if(updateProductForm == null || updateProductForm.getProductId() == null){
            return false;
        }
        try {
            ProductDO productDO = productManager.selectByPrimaryKey(updateProductForm.getProductId());
            if(productDO.getProductName() == null){
                return false;
            }
            //更新参数注入
            if(!StringUtils.isEmpty(updateProductForm.getProductDesc())){
                productDO.setProductDesc(updateProductForm.getProductDesc());
            }
            if(!StringUtils.isEmpty(updateProductForm.getProductName())){
                productDO.setProductName(updateProductForm.getProductName());
            }
            if(updateProductForm.getTeamId() != null){
                productDO.setTeamId(updateProductForm.getTeamId());
            }
            productManager.updateByPrimaryKeySelective(productDO);
            logger.info("更新产品信息,产品id"+productDO.getProductId());
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public BizResult<ProductDO> addProduct(AddProductForm addProductForm) {
        BizResult bizResult = new BizResult();
        if(addProductForm == null || StringUtils.isEmpty(addProductForm.getProductDesc()) || StringUtils.isEmpty(addProductForm.getProductName()) || addProductForm.getTeamId() == null){
            bizResult.setSuccess(false);
            bizResult.setMsg("参数为空，创建失败！");
        }
        try {
            ProductDO productDO = new ProductDO();
            productDO.setProductDesc(addProductForm.getProductDesc());
            productDO.setProductName(addProductForm.getProductName());
            productDO.setStatus(ProductStatusEnum.using.getCode());
            productDO.setTeamId(addProductForm.getTeamId());
            productManager.insertSelective(productDO);
            bizResult.setResult(productDO);
            bizResult.setSuccess(true);
        }catch (Exception e){
            bizResult.setSuccess(false);
            bizResult.setMsg("服务器异常");
            logger.error(e.getMessage());
        }
        return bizResult;
    }

    @Override
    public List<Long> findProductIdsByTeamIds(List<Long> teamIds) {
        List<Long> productIds = new ArrayList<>();
        if(teamIds == null || teamIds.size() == 0){
            return productIds;
        }
        ProductQuery query = new ProductQuery();
        query.createCriteria().andTeamIdIn(teamIds);
        List<ProductDO> productDOs = productManager.selectByQuery(query);
        for(ProductDO productDO : productDOs){
            productIds.add(productDO.getProductId());
        }
        return productIds;
    }

    @Override
    public Long queryTeamIdByProductId(Long productId) {
        if(productId == null){
            return null;
        }
        ProductDO productDO = productManager.selectByPrimaryKey(productId);
        return productDO.getTeamId();
    }

    @Override
    public BizResult deleteProduct(DeleteProductForm deleteProductForm) {
        BizResult bizResult = new BizResult();
        if(deleteProductForm==null || deleteProductForm.getProductId() == null){
            bizResult.setSuccess(false);
            return bizResult;
        }
        ProductDO productDO = productManager.selectByPrimaryKey(deleteProductForm.getProductId());
        productDO.setStatus(ProductStatusEnum.Deleted.getCode());
        productManager.updateByPrimaryKeySelective(productDO);
        bizResult.setSuccess(true);
        return bizResult;
    }

}
