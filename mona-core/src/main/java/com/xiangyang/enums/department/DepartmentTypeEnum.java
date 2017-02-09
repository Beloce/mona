package com.xiangyang.enums.department;

/**
 * Created by xiangyang on 17/2/9.
 */
public enum DepartmentTypeEnum {
    Business(0,"业务方"),
    Tech(1,"技术方");

    private Integer code;
    private String desc;

    DepartmentTypeEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {return code;}

    public String getDesc() {return desc;}
}
