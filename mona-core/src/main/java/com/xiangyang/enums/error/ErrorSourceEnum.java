package com.xiangyang.enums.error;

/**
 * Created by peiji on 2017/1/31.
 */
public enum  ErrorSourceEnum {
    Online(1,"线上问题"),
    Business(2,"业务方问题"),;

    Integer code;
    String desc;

    ErrorSourceEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {return code;}

    public String getDesc() {return desc;}
}
