package com.xiangyang.enums.team;

/**
 * Created by peiji on 2017/3/30.
 */
public enum  TeamRoleEnum {
    Exit(1,"存在"),
    Deleted(2,"已删除"),;


    private int code;

    private String desc;

    TeamRoleEnum(int code, String desc) {
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
