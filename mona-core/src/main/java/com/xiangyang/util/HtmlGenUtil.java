package com.xiangyang.util;

import java.util.List;

/**
 * Created by peiji on 2017/5/4.
 */
public class HtmlGenUtil {
    public final static String questionHtmlGen(String errorTitile, String gmtCreateStr, String reason, List<String> imgList){
        String imgStr="";
        for(String imgUrl : imgList){
            imgStr += "<img src='"+imgUrl+"' width='50%'></img>";
        }
        String html = " <p>系统异常名称：<font size='6' color='#ff0000'>"+errorTitile+"</font></p><p><font size='2'>发生时间：</font><font size='6'>"+gmtCreateStr+"</font></p>" +
                "<p>问题原因：<font size='6' color='#00ff00'>"+reason+"</font></p><p>截图信息：</p><p>"+imgStr+"</p><p><br></p>";
        return html;
    }




}
