package com.xiangyang.AO.impl;

import com.xiangyang.AO.DepartmentAO;
import com.xiangyang.enums.department.DepartmentLevelEnum;
import com.xiangyang.form.DepartmentForm;
import com.xiangyang.manager.DepartmentManager;
import com.xiangyang.model.DepartmentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiangyang on 17/1/5.
 */
@Service
public class DepartmentAOImpl implements DepartmentAO{
    @Autowired
    DepartmentManager departmentManager;

    public DepartmentForm selectDeparmentFormByDepartmentId(Long departmentId) {
        DepartmentForm departmentForm = new DepartmentForm();
        if(departmentId!=null){
            DepartmentDO departmentDO=departmentManager.selectByPrimaryKey(departmentId);

            if(departmentDO!=null){//能从数据库中取到值
                List<DepartmentDO> DepartmentDOs = new LinkedList<DepartmentDO>();
                DepartmentDOs.add(departmentDO);

                departmentForm.setDepartmentDOs(DepartmentDOs);
                Integer departmentLevel = departmentDO.getDepartmentLevel();
                if(!departmentLevel.equals(DepartmentLevelEnum.TopLevel)){//非顶级部门成员

                    for(int i = 0 ; i<departmentLevel;i++){//递归查询上级部门
                        departmentDO = selectDeparmentDOByDepartmentId(departmentDO.getDepartmentFatherId());
                        if(departmentDO!=null){
                            departmentForm.getDepartmentDOs().add(0,departmentDO);
                        }else{
                            return departmentForm;
                        }
                    }
                }
            }
        }else{
            return null;
        }
        return departmentForm;
    }

    public DepartmentDO selectDeparmentDOByDepartmentId(Long departmentId){
        if(departmentId!=null) {
            DepartmentDO departmentDO = departmentManager.selectByPrimaryKey(departmentId);
            if(departmentDO != null){
                return departmentDO;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public Integer queryDepartmentTypeById(Long departmentId) {
        if(departmentId == null){
            return null;
        }
        DepartmentDO departmentDO = this.queryTopLevelDepartmentDObyId(departmentId);
        if(departmentDO!=null ){
            return departmentDO.getDepartmentType();
        }else {
            return null;
        }

    }

    @Override
    public DepartmentDO queryTopLevelDepartmentDObyId(Long departmentId) {
        if(departmentId == null){
            return null;
        }
        DepartmentDO departmentDO = departmentManager.selectByPrimaryKey(departmentId);
        if(departmentDO.getDepartmentLevel()!=null) {
            Integer departmentLevel = departmentDO.getDepartmentLevel();
            for (int i = 0; i < departmentLevel; i++) {
                departmentDO = departmentManager.selectByPrimaryKey(departmentDO.getDepartmentFatherId());
            }
        }
        return departmentDO;
    }

}
