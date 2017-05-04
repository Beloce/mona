package com.xiangyang.util;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

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
    public static final String HH_mm = "HH:mm";

    final Logger logger  =  LoggerFactory.getLogger(this.getClass());
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

    public static Date formatStrToDate(String pattern,String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateStr);
    }
    public static String formatDateToStr(String pattern,Date date) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
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

    public static final String DateToStr(Date date ,String format){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }

    public static final String getHourAndMin(Date date){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(TimeUtils.HH_mm);
            return sdf.format(date);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }


    //获得当天0点时间
    public static Date getTodayStartTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    //获得当天24点时间
    public static Date getTodayEndTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }



    //获得当天0点时间
    public static Date getDateStartTime(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    //获得当天24点时间
    public static Date getDateEndTime(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static String formatRelativeTime(Date dateFromDB){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datenow = TimeUtils.getNow();
        long l = datenow.getTime()-dateFromDB.getTime();
        long day =  l/(1000*60*60*24);
        long hour = l%(1000*60*60*24)/(60*60*1000);
        long minutes = l%(1000*60*60*24)%(60*60*1000)/(1000*60);

        if(day > 10){//大于10天
            return TimeUtils.DateToStr(dateFromDB,"yyyy-MM-dd");
        }
        else if(day > 1){//大于3天小于10天
            return day+"天前";
        }
        else if(day > 0 ){//大于0天小于1天
            return day+"天"+hour+"小时前";
        }
        else if(hour > 3){
            return hour+"小时前";
        }
        else if(hour > 0){
            return hour+"小时"+minutes+"分钟前";
        }
        else {
            return minutes+"分钟前";
        }
    }

    public static String getTodayDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY年MM月DD);
        return sdf.format(new Date());
    }
}