package com.xiangyang.AO;

import com.xiangyang.form.DepartmentForm;
import com.xiangyang.model.DepartmentDO;
import com.xiangyang.model.UserDO;

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


    /**
     * 根据部门id查询该部门的角色(详见枚举类DepartmentEnum)
     * @param departmentId
     * @return
     */
    Integer queryDepartmentTypeById(Long departmentId);

    /**
     * 通过id查询该部门对应的顶级部门
     * @param departmentId
     * @return
     */
    DepartmentDO queryTopLevelDepartmentDObyId(Long departmentId);

    /**
     * 通过userDO来查询该用户所在的最低级部门
     * @param userDO
     * @return
     */
    DepartmentDO queryDepartmentDOByUserDO(UserDO userDO);
}
