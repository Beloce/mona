package com.xiangyang.enums.errorrecord;

/**
 * Created by xiangyang on 17/4/18.
 */
public enum ErrorRecordStatusEnum {
    USING(1,"生效"),
    DELETED(-1,"已删除"),;

    private Integer code;

    private String desc;

    ErrorRecordStatusEnum(Integer code, String desc) {
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
