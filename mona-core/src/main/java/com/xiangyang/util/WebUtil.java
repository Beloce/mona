package com.xiangyang.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by peiji on 2017/1/25.
 */
public class WebUtil {
    private static final Logger log = LoggerFactory.getLogger(WebUtil.class);
    /**
     * 是否是ajax请求
     *
     * @param req
     * @return
     */
    public static boolean isJson(HttpServletRequest req) {
        return req.getRequestURI().endsWith(".json");
    }

    /**
     * 获取 redirectURL
     *
     * @param httpRequest
     * @param path
     * @return
     *//*
    public static String getRedirectUrl(HttpServletRequest httpRequest, String path) {
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromContextPath(httpRequest).path(path).queryParam(FerrariConstant.REDIRECT_URL, ServletUriComponentsBuilder.fromRequest(httpRequest).build().encode().toUriString());
        return builder.build().encode().toUriString();
    }
*/
    /**
     * 获取 redirectURL，跳转URL为 referer
     *
     * @param httpRequest
     * @param path
     * @return
     */
    public static String getRedirectUrlFromReferer(HttpServletRequest httpRequest, String path) {
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromContextPath(httpRequest).path(path).queryParam("redirectURL", httpRequest.getHeader("referer"));
        return builder.build().encode().toUriString();
    }

    /**
     * 返回上一次请求的页面
     * @param httpRequest
     */
    public static String getLastUrlFromReferer(HttpServletRequest httpRequest){
        return httpRequest.getHeader("referer");
    }


    public static String getString(String key, Map m) {
        if (m == null || key == null || m.get(key) == null) {
            return null;
        }
        return String.valueOf(m.get(key));
    }

    public static boolean isNumber(String str){
        if(!StringUtils.isBlank(str)){
            return str.matches("[0-9]+");
        }else{
            return false;
        }
    }

}
