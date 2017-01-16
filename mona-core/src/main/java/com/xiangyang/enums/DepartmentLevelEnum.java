package com.xiangyang.enums;

/**
 * Created by xiangyang on 16/11/23.
 */
public enum DepartmentLevelEnum {
    TopLevel(0,"一级部门"),
    SecondLevel(1,"二级部门"),
    ThirdLevel(2,"三级部门"),;

    private Integer type;

    private String desc;

    DepartmentLevelEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
