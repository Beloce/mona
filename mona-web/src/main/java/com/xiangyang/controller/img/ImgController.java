package com.xiangyang.controller.img;

import com.xiangyang.AO.UserAO;
import com.xiangyang.BizResult;
import com.xiangyang.manager.ImageManager;
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

    final String HEAD_TMP_PATH = "/img/headImg";//头像图片压缩后的临时文件夹

    final String OTHER_TMP_PATH = "/img/other";

    final String TEMP_IMG_PATH = "/img/tmp" ;//所有上传文件的临时文件夹

    @Autowired
    UserAO userAO;

    @Autowired
    ImageManager imageManager;

    /**
     * 头像上传
     * @param uplodHeadImgAjax
     * @param request
     * @return
     */
    @RequestMapping(value="/uploadHeadImg.json",method = RequestMethod.POST)
    @ResponseBody
    public Object uploadHeadImg(MultipartFile uplodHeadImgAjax, HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setHeader("Access-Control-Allow-Origin","*");
        BizResult bizResult = new BizResult();
        BizResult upResult = new BizResult();
        String geneTempPicPath=request.getSession().getServletContext().getRealPath(TEMP_IMG_PATH);//临时目录
        String TempHeadPicPath=request.getSession().getServletContext().getRealPath(HEAD_TMP_PATH);//压缩后的临时目录
        if (uplodHeadImgAjax.isEmpty()) {
            bizResult.setSuccess(false);
            bizResult.setMsg("图片数据为空");
        }else {
            UserDO userDO = UserUtil.getUser();
            try{
                String prefix=uplodHeadImgAjax.getOriginalFilename().substring(uplodHeadImgAjax.getOriginalFilename().lastIndexOf(".")+1);
                String filename = uplodHeadImgAjax.getOriginalFilename();//上传文件的文件名

                //将上传的图片放到/img/tmp服务器下
                File tempFile = new File(geneTempPicPath,filename);
                FileUtils.copyInputStreamToFile(uplodHeadImgAjax.getInputStream(), tempFile);
                String tempImgPath = geneTempPicPath+File.separatorChar+filename;
                String tempHeadImgPath = TempHeadPicPath+File.separatorChar+filename;
                //头像图像压缩;
                if (ImgUtil.scaleImageWithParams(tempImgPath,tempHeadImgPath,200,200,false,prefix)){//压缩成功
                    FileUtils.deleteQuietly(tempFile);//删除源文件
                    File headTempImg = new File(tempHeadImgPath);
                    upResult = imageManager.upload(headTempImg);//上传至七牛云
                    if(upResult.isSuccess()){//上传成功
                        bizResult.setSuccess(true);
                        userDO.setHeadImg((String)upResult.getResult());
                        bizResult.setMsg((String)upResult.getResult());
                        userAO.updateUserByUserDO(userDO);
                    }else {
                        bizResult.setSuccess(false);
                    }
                    FileUtils.deleteQuietly(headTempImg);//删除临时头像问价
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
        FileUtils.cleanDirectory(new File(geneTempPicPath));
        FileUtils.cleanDirectory(new File(TempHeadPicPath));
        return bizResult;
    }

    /**
     * 上传除头像外的其他图片
     * @param uploadImgAjax
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value ="/uploadImg.json",method = RequestMethod.POST)
    @ResponseBody
    public Object uploadImg(MultipartFile uploadImgAjax,HttpServletRequest request) throws Exception{
        BizResult bizResult = new BizResult();
        BizResult upResupt = new BizResult();
        String geneTempPicPath=request.getSession().getServletContext().getRealPath(TEMP_IMG_PATH);
        String genePicPath = request.getSession().getServletContext().getRealPath(OTHER_TMP_PATH);
        if (uploadImgAjax.isEmpty()) {
            bizResult.setSuccess(false);
            bizResult.setMsg("图片数据为空");
        }else {
            try{
                logger.info("|------开始上传图片-------|");
                String prefix=uploadImgAjax.getOriginalFilename().substring(uploadImgAjax.getOriginalFilename().lastIndexOf(".")+1);
                String filename = uploadImgAjax.getOriginalFilename();
                //将上传的图片放到/img/tmp服务器下
                File tempFile = new File(geneTempPicPath,filename);
                FileUtils.copyInputStreamToFile(uploadImgAjax.getInputStream(), tempFile);//将文件流转换成文件
                String tempImgPath = geneTempPicPath+File.separatorChar+filename;//临时存储的源文件
                String ImgPath = genePicPath+File.separatorChar+filename;//压缩后的临时文件
                if(new File(tempImgPath).length() > (2*1024*1024)){//如果上传的文件过于庞大，压缩
                    ImgUtil.scaleImage(tempImgPath,ImgPath,0.4,prefix);
                    FileUtils.deleteQuietly(new File(tempImgPath));
                }else{
                    FileUtils.moveFile(new File(tempImgPath),new File(ImgPath));
                }
                File file = new File(ImgPath);
                BizResult upResult = new BizResult();
                upResult = imageManager.upload(file);
                if(upResult.isSuccess()){
                    bizResult.setSuccess(true);
                    bizResult.setResult((String)upResult.getResult());
                }else {
                    bizResult.setSuccess(false);
                }
                FileUtils.deleteQuietly(file);
            }catch(Exception e) {

                bizResult.setSuccess(false);
                bizResult.setMsg("服务器异常");
                logger.error("|----上传服务器异常------|",e);
            }
            logger.info("|--------上传图片成功-------|");
        }
        FileUtils.cleanDirectory(new File(geneTempPicPath));
        FileUtils.cleanDirectory(new File(genePicPath));
        return bizResult;

    }
}
