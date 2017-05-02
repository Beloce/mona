package com.xiangyang.enums.error;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xiangyang on 17/5/2.
 */
public enum ResponsibilityEnum {
    DEV(1,"开发方"),
    BUS(2,"业务方"),
    THIRD(3,"第三方");

    Integer code;
    String desc;

    ResponsibilityEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {return code;}

    public String getDesc() {return desc;}

    /*
    遍历所有的枚举元素
     */
    public static LinkedHashMap<String,String> getCodeAndDescMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        for(ResponsibilityEnum re : ResponsibilityEnum.values()){
            map.put(re.getCode().toString(),re.getDesc());
        }
        return map;
    }
}
