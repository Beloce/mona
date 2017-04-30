package com.xiangyang.controller.product;

import com.xiangyang.AO.ProductAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.ProductVO;
import com.xiangyang.enums.RoleEnum;
import com.xiangyang.form.product.CreateProductForm;
import com.xiangyang.form.product.UpdateProductForm;
import com.xiangyang.model.ProductDO;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peiji on 2017/3/19.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductAO productAO;

    @RequiresRoles("admin")
    @RequestMapping("list.htm")
    public String getProductList(ModelMap modelMap){
        BizResult<List<ProductVO>> bizResult = productAO.queryAllProductVOList();
        modelMap.addAttribute("productList",bizResult.getResult());
        return "/product/list";
    }

    @RequiresRoles("admin")
    @RequestMapping("detail.htm")
    public Object getDetail(@RequestParam Long productId){
        BizResult bizResult = new BizResult();
        bizResult = productAO.queryProductDOById(productId);
        return bizResult;
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "/update.json",method = RequestMethod.POST)
    public Object update(@RequestBody UpdateProductForm updateProductForm){
        BizResult bizResult = new BizResult();
        boolean flag = productAO.updateProductDO(updateProductForm);
        bizResult.setSuccess(flag);
        return bizResult;
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "/create.json",method = RequestMethod.POST)
    public Object create(@RequestBody CreateProductForm createProductForm){
        BizResult bizResult = new BizResult();
        bizResult = productAO.addProduct(createProductForm);
        return bizResult;
    }

    @RequestMapping(value = "/getAll.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getAll(){
        BizResult<List<ProductVO>> bizResult = productAO.queryAllProductVOList();
        return bizResult.getResult();
    }


}
