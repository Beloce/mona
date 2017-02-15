package com.xiangyang.AO.impl;

import com.xiangyang.AO.ErrorAO;
import com.xiangyang.BizResult;
import com.xiangyang.enums.error.ErrorSourceEnum;
import com.xiangyang.enums.error.ErrorStatusEnum;
import com.xiangyang.enums.error.ErrorTypeEnum;
import com.xiangyang.form.error.ErrorForm;
import com.xiangyang.manager.ErrorManager;
import com.xiangyang.model.DepartmentDO;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.query.ErrorQuery;
import com.xiangyang.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        errorDO.setProviderId(errorForm.getUserDO().getUserId());
        errorDO.setType(errorForm.getErrorType());
        errorDO.setScreenshot(errorForm.getScreenshot());
        errorDO.setSource(ErrorSourceEnum.Business.getCode());
        errorDO.setStatus(ErrorStatusEnum.Create.getCode());
        errorDO.setGmtCreate(nowData);
        errorDO.setGmtModified(nowData);
        errorManager.insertSelective(errorDO);

        return bizResult;
    }

    @Override
    public List<ErrorDO> queryBussinessErrorListByUserDO(UserDO userDO) {
        /*
        获取当前用户名下的所有业务问题
         */
        List<ErrorDO> errorDOs = new ArrayList<ErrorDO>();
        DepartmentDO departmentDO = new DepartmentDO();
        if(departmentDO == null || departmentDO.getDepartmentId() == null){
            return errorDOs;
        }





        ErrorQuery errorQuery = new ErrorQuery();
        errorQuery.createCriteria().andSourceEqualTo(ErrorSourceEnum.Business.getCode());

        return null;
    }
}
