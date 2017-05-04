package com.xiangyang.enums.error;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xiangyang on 17/5/2.
 */
public enum ResolveTypeEnum {
    DEV(1,"数据订正"),
    BUS(2,"重新发布"),
    THIRD(3,"其他方式");

    Integer code;
    String desc;

    ResolveTypeEnum(Integer code,String desc){
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
        for(ResolveTypeEnum re : ResolveTypeEnum.values()){
            map.put(re.getCode().toString(),re.getDesc());
        }
        return map;
    }
    public static String getDescByCode(Integer code){
        for(ResolveTypeEnum resolveTypeEnum : ResolveTypeEnum.values()){
            if(code.equals(resolveTypeEnum.getCode())){
                return resolveTypeEnum.getDesc();
            }
        }
        return "";
    }
}
