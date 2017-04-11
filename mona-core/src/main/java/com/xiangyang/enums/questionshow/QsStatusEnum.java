package com.xiangyang.enums.questionshow;

/**
 * Created by xiangyang on 17/4/11.
 */
public enum QsStatusEnum {
    using(1,"正在被使用"),
    Deleted(-1,"已删除"),;


    private Integer code;

    private String desc;

    QsStatusEnum(Integer code, String desc) {
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
