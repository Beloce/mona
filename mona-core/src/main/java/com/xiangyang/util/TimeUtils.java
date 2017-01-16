package com.xiangyang.util;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiangyang on 16/11/24.
 */
public class TimeUtils {

    /**
     * 获取当前时间
     * @param format 字符串类型格式
     * @return 规定格式的当前字符串时间
     */
    public static String getCurrentTime(String format){
        Date date = new Date();
        String time = "";
        if(!StringUtils.isEmpty(format)){
            DateFormat dateFormat1=new SimpleDateFormat(format);
            time=dateFormat1.format(date);
        }else {
            DateFormat dateFormat2=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            time=dateFormat2.format(date);
        }
        return time;
    }
}