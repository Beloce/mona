package com.xiangyang.controller.product;

import com.xiangyang.AO.ProductAO;
import com.xiangyang.BizResult;
import com.xiangyang.model.ProductDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("list.htm")
    public String getProductList(ModelMap modelMap){
        BizResult<List<ProductDO>> bizResult = productAO.queryAllProductList();

        modelMap.addAttribute("productList",bizResult.getResult());
        return "/product/list";

    }
}
