package com.xiangyang.controller.img;

import com.xiangyang.BizResult;
import com.xiangyang.util.ImgUtil;
import com.xiangyang.util.MD5Util;
import com.xiangyang.util.TimeUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by xiangyang on 16/11/24.
 */
@Controller
@RequestMapping("/img")
public class ImgController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value="/uploadImg.json",method = RequestMethod.POST)
    @ResponseBody
    public Object importPicFile(MultipartFile uplodHeadImgAjax, HttpServletRequest request, HttpServletResponse response) {
        BizResult bizResult = new BizResult();
        if (uplodHeadImgAjax.isEmpty()) {
            bizResult.setSuccess(false);
            bizResult.setMsg("图片数据为空");
        }else {
            try{
                String prefix=uplodHeadImgAjax.getOriginalFilename().substring(uplodHeadImgAjax.getOriginalFilename().lastIndexOf(".")+1);
                String filename = MD5Util.MD5(TimeUtils.getCurrentTime("yyyyMMddHHmmss"))+"."+prefix;
                String geneTempPicPath=request.getSession().getServletContext().getRealPath("/imgs/temp");
                String genePicPath = request.getSession().getServletContext().getRealPath("/imgs");
                //将上传的图片放到/upload服务器下
                File tempFile = new File(geneTempPicPath,filename);
                FileUtils.copyInputStreamToFile(uplodHeadImgAjax.getInputStream(), tempFile);

                String tempImgPath = geneTempPicPath+File.separatorChar+filename;
                String ImgPath = genePicPath+File.separatorChar+filename;

                if (ImgUtil.scaleImageWithParams(tempImgPath,ImgPath,200,200,false,prefix)){//压缩成功
                    FileUtils.deleteQuietly(tempFile);
                    bizResult.setSuccess(true);
                    bizResult.setMsg("/imgs/"+filename);
                }
                else{
                    bizResult.setSuccess(false);
                }
            }catch(Exception e) {
                bizResult.setSuccess(false);
                bizResult.setMsg("服务器异常");
                logger.error("上传服务器异常",e);
            }
        }
        return bizResult;
    }
}
