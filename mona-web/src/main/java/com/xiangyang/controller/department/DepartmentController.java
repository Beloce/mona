package com.xiangyang.controller.department;

import com.xiangyang.AO.DepartmentAO;
import com.xiangyang.BizResult;
import com.xiangyang.model.DepartmentDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xiangyang on 17/3/24.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentAO departmentAO;

    final Logger logger  =  LoggerFactory.getLogger(this.getClass());
    /**
     * 获取技术部门下的子部门情况，广度遍历
     * @param modelMap
     * @return
     */
    @RequestMapping("/departmentList.htm")
    public String departmentList(ModelMap modelMap){
        Long techDepartTopId = 12l;//暂时写死
        List<DepartmentDO> departmentDOs = departmentAO.querySonDepartmentListById(techDepartTopId);
        modelMap.addAttribute("departmentTreeList",departmentDOs);
        return "/department/departmentList";
    }

    /**
     * 异步获取某部门下的所有子部门情况，广度遍历
     * @param departmentId
     * @return
     */
    @RequestMapping(value = "/getDepartmentListAjax.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getDepartmentListAjax(@RequestBody Long departmentId){
        BizResult bizResult = new BizResult();
        if(departmentId == null){
            bizResult.setSuccess(false);
            bizResult.setMsg("参数为空");
            return bizResult;
        }
        List<DepartmentDO> departmentDOs = departmentAO.querySonDepartmentListById(departmentId);
        bizResult.setSuccess(true);
        logger.info("【查询部门列表】");
        bizResult.setResult(departmentDOs);
        return bizResult;
    }
}
