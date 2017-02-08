package com.xiangyang.enums.error;

/**
 * Created by peiji on 2017/1/31.
 * 问题的处理状态
 */
public enum ErrorStatusEnum {

    Create(1,"已创建，待确认"),
    Confirm(2,"已确认，正在处理"),
    Processed(3,"已处理"),
    Evaluate(4,"反确认,并评价"),
    Over(5,"结束"),
    Close(6,"关闭"),;

    private Integer code;
    private String desc;

    ErrorStatusEnum(Integer code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
