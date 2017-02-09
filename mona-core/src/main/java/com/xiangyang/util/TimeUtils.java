package com.xiangyang.util;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by xiangyang on 16/11/24.
 */
public class TimeUtils {
    public static final String YYYY_MM_DD_HH_MM_SS_MS = "yyyy-MM-dd HH:mm:ss.S";
    public static final String YYYY_MM_DD_HH_MM_SS_SS = "yyyy-MM-dd HH:mm:ss:SS";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY年MM月DD_HH_MM_SS = "yyyy年MM月dd日 HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY年MM月DD = "yyyy年MM月dd日";
    public static final String YYYY年MM月 = "yyyy年MM月";
    public static final String YYYYMMDD_HHMMSS = "yyyyMMdd HHmmss";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMM = "yyyyMM";
    public static final String YYMM = "yyMM";
    public static final String YYYY = "yyyy";
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
            DateFormat dateFormat2=new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_SS);
            time=dateFormat2.format(date);
        }
        return time;
    }

    public static final Date getNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return sdf.parse(getNowTime());
        } catch (ParseException var2) {
            var2.printStackTrace();
            return new Date();
        }
    }

    public static final String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format((new GregorianCalendar()).getTime());
    }
}