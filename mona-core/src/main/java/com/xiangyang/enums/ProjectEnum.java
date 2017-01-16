package com.xiangyang.enums;

/**
 * Created by xiangyang on 16/11/22.
 */
public enum ProjectEnum {
    Business(1,"商家事业项目"),
    Logistics(2,"仓储物流事业项目"),
    SeekCar(3,"寻车项目"),
    SellCar(4,"卖车项目"),
    DMS(5,"DMS项目"),
    EToCar(6,"新项目项目"),
    Share(7,"平台共享项目"),;

    private Integer type;

    private String desc;

    ProjectEnum(Integer type, String desc) {
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
