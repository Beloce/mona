package com.xiangyang.manager.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.xiangyang.BizResult;
import com.xiangyang.manager.ImageManager;
import com.xiangyang.util.MD5Util;
import com.xiangyang.util.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by peiji on 2017/2/12.
 */
@Component
public class ImageManagerImpl implements ImageManager {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 七牛图片 密钥 图片地址
     */
    private final static String IMG_DOMAIN = "http://ol50swx9z.bkt.clouddn.com";

    private final static String BUCKET_NAME = "mona";
    private final static String ACCESS_KEY = "EyZtmHir-hvb9lKCMHK_Pov0w2KInWwptvKZ4z8D";
    private final static String SECRET_KEY = "XADVjQPQ4COKnO__RTRpSFfZz_oaUlg7cLq31TSf";

    /**
     * 上传区域 /华东
     */
    Zone z = Zone.zone0();
    Configuration c = new Configuration(z);

    UploadManager uploadManager = new UploadManager(c);
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    /**
     * 获取token
     * @return
     */
    public String getUpToken() {
        return auth.uploadToken(BUCKET_NAME);
    }

    /**
     * 更具当前时间生成文件名
     * @param prefix
     * @return
     */
    public String createFileNameByMd5(String prefix){
        return MD5Util.MD5(TimeUtils.getCurrentTime("yyyyMMddHHmmss")+System.currentTimeMillis())+"."+prefix;
    }

    /**
     * 七牛上传文件
     *
     * @param file 文件
     * @return
     */
    public BizResult upload(File file) throws IOException {
        BizResult bizResult = new BizResult();
        try {
            String filePrefix = file.getName().substring(file.getName().lastIndexOf(".")+1);
            //调用put方法上传
            String key = createFileNameByMd5(filePrefix);
            Response res = uploadManager.put(file.getPath(), key , getUpToken());
            //打印返回的信息
//          System.out.println(res.bodyString());
            bizResult.setSuccess(true);
            bizResult.setResult(new String(IMG_DOMAIN+"/"+key));
        } catch (QiniuException e) {
            bizResult.setSuccess(false);
            Response r = e.response;
            // 请求失败时打印的异常的信息
            logger.error(r.toString());
        }
        return bizResult;
    }


}
