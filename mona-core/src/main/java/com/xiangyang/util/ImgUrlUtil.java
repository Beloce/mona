package com.xiangyang.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by peiji on 2017/2/23.
 *
 */
/**
 * Created by houenxun on 16/1/14.
 * 图片链接工具 对多个图片链接进行统一拆分和合并
 */
public class ImgUrlUtil {
    public static final String SPLIT = "#*#";
    public static final String CLI_SPLIT = ";";


    public static List<String> parseList(String imgs) {
        List<String> list = new ArrayList<String>();
        if (StringUtils.isBlank(imgs)) {
            return list;
        }
        String[] imgArray = imgs.split(SPLIT);
        for (String img : imgArray) {
            if (StringUtils.isNotBlank(img) && !img.equals("*")) {
                //客户端上传链接是用";"做分割,为了适配再根据";" 做一次切割
                String[] tmpStrs = img.split(CLI_SPLIT);
                for (String tmp : tmpStrs) {
                    if (StringUtils.isNotBlank(tmp) && !tmp.equals("*")) {
                        list.add(tmp.trim());
                    }
                }
            }
        }
        return list;
    }

    public static String mergeList(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (String img : list) {
            if (StringUtils.isNotBlank(img)) {
                builder.append(img.trim()).append(SPLIT);
            }
        }
        if (StringUtils.isBlank(builder.toString())) {
            return null;
        }
        return builder.substring(0, builder.length() - SPLIT.length());
    }
}
