package com.xiangyang.enums.error;

/**
 * Created by xiangyang on 17/4/18.
 */
public enum  OperationSignalEnum {
    CONFIRM_ERROR(1,"确认问题"),
    POINT_ERROR(2,"指派问题"),
    CLOSE_ERROR(3,"关闭问题"),
    SOLVE_ERROR(4,"已解决问题"),
    CONFIRM_SOLVE_ERROR(5,"确认解决，评论问题"),
    REJECT_SOLVE_ERROR(6,"问题未解决"),
    FILL_INVENTORY_ERROR(7,"填写问题清单"),;

    Integer code;
    String desc;

    OperationSignalEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {return code;}

    public String getDesc() {return desc;}

}
