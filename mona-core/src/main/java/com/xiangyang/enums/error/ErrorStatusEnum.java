package com.xiangyang.enums.error;

import java.util.LinkedHashMap;

/**
 * Created by peiji on 2017/1/31.
 * 问题的处理状态
 */
public enum ErrorStatusEnum {

    CREATED(1,"已创建，待确认"),
    CONFIRMED(2,"已确认，正在处理"),
    PROCESSED(3,"已处理，待验证"),
    VALIDATED(4,"已验证，待填写问题清单"),
    OVER(6,"问题完结"),
    CLOSED(7,"被关闭"),;

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

    public static String getDescByCode(Integer code){
        for (ErrorStatusEnum errorStatusEnum : ErrorStatusEnum.values()){
            if(code.equals(errorStatusEnum.getCode())){
                return errorStatusEnum.desc;
            }
        }
        return "";
    }
    public static LinkedHashMap<String,String> getCodeAndDescMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        for(ErrorStatusEnum es : ErrorStatusEnum.values()){
            map.put(es.getCode().toString(),es.getDesc());
        }
        return map;
    }
}
