package com.xiangyang.enums.errorrecord;

import com.xiangyang.enums.error.ErrorStatusEnum;

/**
 * Created by xiangyang on 17/4/18.
 */
public enum ErrorRecordOpTypeEnum {
    PUBLISH(1,"发布"),
    POINT(2,"指派"),
    CONFIRM(3,"确认"),
    CLOSE(4,"关闭"),
    RESOLVE(5,"已解决"),
    RESOLVE_CONFIRM(6,"解决确认"),
    RESOLVE_REJECT(7,"解决驳回"),
    COMMENT(8,"评论"),
    FILL_INVENTORY(9,"填写问题清单"),;


    Integer code;
    String desc;

    ErrorRecordOpTypeEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {return code;}

    public String getDesc() {return desc;}

    public static String getDescByCode(Integer code){
        for (ErrorRecordOpTypeEnum ErrorRecordOpTypeEnum : ErrorRecordOpTypeEnum.values()){
            if(code.equals(ErrorRecordOpTypeEnum.getCode())){
                return ErrorRecordOpTypeEnum.desc;
            }
        }
        return "";
    }
}
