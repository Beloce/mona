package com.xiangyang.enums;

/**
 * Created by xiangyang on 17/1/18.
 */
public enum  IsDeletedEnum {
    Exit(1,"存在"),
    Deleted(2,"已删除"),;


    private Integer code;

    private String desc;

    IsDeletedEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
