package com.xiangyang.controller.product;

import com.xiangyang.AO.ProductAO;
import com.xiangyang.AO.TeamAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.ProductVO;
import com.xiangyang.VO.TeamVO;
import com.xiangyang.enums.RoleEnum;
import com.xiangyang.form.product.AddProductForm;
import com.xiangyang.form.product.DeleteProductForm;
import com.xiangyang.form.product.UpdateProductForm;
import com.xiangyang.form.team.AddTeamForm;
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

    @Autowired
    TeamAO teamAO;

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
    @RequestMapping(value = "/delete.json",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@RequestBody DeleteProductForm deleteProductForm){
        BizResult bizResult = new BizResult();
        bizResult= productAO.deleteProduct(deleteProductForm);
        return bizResult;
    }

    @RequestMapping(value = "/getAll.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getAll(){
        BizResult<List<ProductVO>> bizResult = productAO.queryAllProductVOList();
        return bizResult.getResult();
    }

    @RequestMapping(value = "/getProduct.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getAll(Long productId){
        ProductVO productVO = productAO.queryProductVOById(productId);
        return productVO;
    }

    @RequestMapping("add.htm")
    public String add(ModelMap modelMap){
        List<TeamVO> teamVOs = teamAO.queryAllTeamVOs();
        modelMap.addAttribute("teamList",teamVOs);
        return "/product/add";
    }

    @RequestMapping("doAdd.htm")
    public String doAdd(AddProductForm addProductForm , ModelMap modelMap){
        productAO.addProduct(addProductForm);
        return "redirect:/product/list.htm";
    }
}
