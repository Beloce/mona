package com.xiangyang.controller.img;

import com.xiangyang.AO.UserAO;
import com.xiangyang.BizResult;
import com.xiangyang.model.UserDO;
import com.xiangyang.util.ImgUtil;
import com.xiangyang.util.MD5Util;
import com.xiangyang.util.TimeUtils;
import com.xiangyang.util.UserUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    final String HEAD_IMG_PATH ="/imgs/headImg/";

    final String TEMP_IMG_PATH = "/imgs/temp/" ;

    @Autowired
    UserAO userAO;



    /**
     * 头像上传
     * @param uplodHeadImgAjax
     * @param request
     * @return
     */
    @RequestMapping(value="/uploadHeadImg.json",method = RequestMethod.POST)
    @ResponseBody
    public Object uploadHeadImg(MultipartFile uplodHeadImgAjax, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        BizResult bizResult = new BizResult();
        if (uplodHeadImgAjax.isEmpty()) {
            bizResult.setSuccess(false);
            bizResult.setMsg("图片数据为空");
        }else {
            UserDO userDO = UserUtil.getUser();
            if(StringUtils.isNotEmpty(userDO.getHeadImg())){
                //删除原来的头像信息
                org.apache.tools.ant.util.FileUtils.delete(new File(request.getSession().getServletContext().getRealPath(userDO.getHeadImg())));
            }
            try{
                String prefix=uplodHeadImgAjax.getOriginalFilename().substring(uplodHeadImgAjax.getOriginalFilename().lastIndexOf(".")+1);
                String filename = MD5Util.MD5(TimeUtils.getCurrentTime("yyyyMMddHHmmss"))+"."+prefix;
                String geneTempPicPath=request.getSession().getServletContext().getRealPath(TEMP_IMG_PATH);
                String genePicPath = request.getSession().getServletContext().getRealPath(HEAD_IMG_PATH);
                //将上传的图片放到/upload服务器下
                File tempFile = new File(geneTempPicPath,filename);
                FileUtils.copyInputStreamToFile(uplodHeadImgAjax.getInputStream(), tempFile);

                String tempImgPath = geneTempPicPath+File.separatorChar+filename;
                String ImgPath = genePicPath+File.separatorChar+filename;

                if (ImgUtil.scaleImageWithParams(tempImgPath,ImgPath,200,200,false,prefix)){//压缩成功
                    FileUtils.deleteQuietly(tempFile);
                    bizResult.setSuccess(true);
                    bizResult.setMsg(HEAD_IMG_PATH+filename);
                    userDO.setHeadImg(HEAD_IMG_PATH+filename);
                    userAO.updateUserByUserDO(userDO);
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
    @RequestMapping(value="/uploadQuestionImg.json",method = RequestMethod.POST)
    @ResponseBody
    public Object uploadQuestionImg(MultipartFile uplodQuestionShowImgAjax, HttpServletRequest request){
        BizResult bizResult = new BizResult();


        return bizResult;

    }
}
