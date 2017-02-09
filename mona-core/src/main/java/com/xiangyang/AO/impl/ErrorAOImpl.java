package com.xiangyang.AO.impl;

import com.xiangyang.AO.ErrorAO;
import com.xiangyang.BizResult;
import com.xiangyang.enums.error.ErrorSourceEnum;
import com.xiangyang.enums.error.ErrorStatusEnum;
import com.xiangyang.form.error.ErrorForm;
import com.xiangyang.manager.ErrorManager;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by xiangyang on 17/2/9.
 */
@Service
public class ErrorAOImpl implements ErrorAO {
    @Autowired
    ErrorManager errorManager;

    @Override
    public BizResult addNewError(ErrorForm errorForm) {
        BizResult bizResult = new BizResult();
        if(errorForm == null){
            bizResult.setMsg("信息为空");
            return bizResult;
        }
        ErrorDO errorDO = new ErrorDO();
        Date nowData = TimeUtils.getNow();
        errorDO.setTitle(errorForm.getTitle());
        errorDO.setDescription(errorForm.getDescription());
        errorDO.setProductId(errorForm.getProductId());
        errorDO.setType(errorForm.getErrorType());
        errorDO.setScreenshot(errorForm.getScreenshot());
        errorDO.setSource(ErrorSourceEnum.Business.getCode());
        errorDO.setStatus(ErrorStatusEnum.Create.getCode());
        errorDO.setGmtCreate(nowData);
        errorDO.setGmtModified(nowData);
        errorManager.insertSelective(errorDO);

        return bizResult;
    }
}
