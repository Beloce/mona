package com.xiangyang.controller.error;

import com.xiangyang.AO.OperationAO;
import com.xiangyang.BizResult;
import com.xiangyang.form.opeartion.PostBusOpForm;
import com.xiangyang.form.opeartion.PostDevOpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by peiji on 2017/4/22.
 */
@Controller
@RequestMapping("/errorop")
public class ErrorOperationController {
    @Autowired
    OperationAO operationAO;

    @RequestMapping(value = "/post.json",method = RequestMethod.POST)
    @ResponseBody
    public Object post(@RequestBody PostDevOpForm postDevOpForm){
        BizResult bizResult = new BizResult();
        if(postDevOpForm == null || postDevOpForm.getOpid() == null || postDevOpForm.getErrorId() == null){
            bizResult.setMsg("参数为空，请刷新页面");
            return bizResult;
        }
        bizResult = operationAO.doDevOperation(postDevOpForm);
        return bizResult;
    }

    @RequestMapping("/mobilePost.json")
    @ResponseBody
    public Object mobilePost(@RequestBody PostBusOpForm postBusOpForm){
        BizResult bizResult = new BizResult();
        if(postBusOpForm == null || postBusOpForm.getOpid() == null || postBusOpForm.getErrorId() == null){
            bizResult.setMsg("参数为空，请刷新页面");
            return bizResult;
        }
        bizResult = operationAO.doBusOperation(postBusOpForm);
        return bizResult;
    }

}
