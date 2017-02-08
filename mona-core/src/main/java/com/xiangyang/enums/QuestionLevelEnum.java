package com.xiangyang.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peiji on 2017/1/25.
 */
public enum QuestionLevelEnum {
    Sticky(1,"首页置顶"),
    SectionSticky(2,"产品板块置顶"),
    Serious(3,"严重"),
    Important(4,"重要"),
    Mark(5,"标记"),
    Normal(6,"普通"),;

    private Integer code;
    private String desc;

    QuestionLevelEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 获取该枚举类的所有类型
     * @return  Map<Integer,String>
     */
    public static Map<Integer,String> getQuestionLevelList(){
        Map<Integer,String> questionLevelMap = new HashMap<Integer,String>();
        for(QuestionLevelEnum entity : QuestionLevelEnum.values()){
            questionLevelMap.put(entity.getCode(),entity.getDesc());
        }
        return questionLevelMap;
    }
}
