package com.xiangyang.AO;

import com.xiangyang.form.DepartmentForm;
import com.xiangyang.model.DepartmentDO;

/**
 * Created by xiangyang on 17/1/5.
 */
public interface DepartmentAO {

    /**
     * 通过departmentId获取部门层级列表（关系）
     * @param departmentId
     * @return DeparmentForm
     */
    DepartmentForm selectDeparmentFormByDepartmentId(Long departmentId);


    /**
     * 通过departmentId获取直属部门
     * @param departmentId
     * @return DepartmentDO
     */
    DepartmentDO selectDeparmentDOByDepartmentId(Long departmentId);
}
