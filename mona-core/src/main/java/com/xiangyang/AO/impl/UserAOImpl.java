package com.xiangyang.AO.impl;

import com.xiangyang.AO.DepartmentAO;
import com.xiangyang.AO.UserAO;
import com.xiangyang.BizResult;
import com.xiangyang.dto.UserInfoDTO;
import com.xiangyang.form.DepartmentForm;
import com.xiangyang.form.UserInfoForm;
import com.xiangyang.manager.UserManager;
import com.xiangyang.model.DepartmentDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.query.UserQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.util.List;

/**
 * Created by xiangyang on 16/11/10.
 */
@Service
public class UserAOImpl implements UserAO {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DepartmentAO departmentAO;

    @Autowired
    UserManager userManager;

    public BizResult getUserInfoByEmail(String email){
        BizResult bizResult = new BizResult();
        UserInfoForm userInfoForm = new UserInfoForm();
        DepartmentForm departmentForm = new DepartmentForm();
        if(!StringUtils.isEmpty(email)){
            UserDO userDO = this.selectUserByEmail(email);
            if(userDO!=null){
                userInfoForm.setEmail(userDO.getEmail());
                userInfoForm.setFlowerName(userDO.getFlowerName());
                userInfoForm.setHeadImg(userDO.getHeadImg());
                userInfoForm.setJobNumber(userDO.getJobNumber());
                userInfoForm.setRealName(userDO.getRealName());
                userInfoForm.setMobile(userDO.getMobile());
                if(userDO.getDepartmentId()!=null){//部门id不为空
                    departmentForm = departmentAO.selectDeparmentFormByDepartmentId(userDO.getDepartmentId());
                }
                UserInfoDTO userInfoDTO = new UserInfoDTO();
                userInfoDTO.setDepartmentForm(departmentForm);
                userInfoDTO.setUserInfoForm(userInfoForm);

                bizResult.setResult(userInfoDTO);
                bizResult.setSuccess(true);
            }else{
                bizResult.setResult(false);
                bizResult.setMsg("用户不存在");
            }

        }else{
             bizResult.setSuccess(false);
             logger.error("-----非法字段传入-----");
        }
        return bizResult;
    }

    public BizResult updateUserInfoByUserInfoForm(UserInfoForm userInfoForm) {
        BizResult bizResult = new BizResult();
        if(userInfoForm!=null){
            UserDO userDO = this.selectUserByEmail(userInfoForm.getEmail());
            if(userInfoForm.getMobile() != null){
                userDO.setMobile(userInfoForm.getMobile());
            }
            if(userInfoForm.getHeadImg()!=null){
                userDO.setHeadImg(userInfoForm.getHeadImg());
            }
            this.updateUserByUserDO(userDO);
        }
        return bizResult;
    }

    public UserDO selectUserByEmail(String email) {
        if(!StringUtils.isEmpty(email)){
            UserQuery userQuery = new UserQuery();
            userQuery.createCriteria().andEmailEqualTo(email);
            List<UserDO> userDOs = userManager.selectByQuery(userQuery);
            if(!CollectionUtils.isEmpty(userDOs)){
                return userDOs.get(0);
            }
            else{
                return null;
            }
        }else {
            return null;
        }
    }

    public boolean updateUserByUserDO(UserDO userDO) {
        try{
            if(userDO!=null&&userDO.getUserId()!=null){
                userManager.updateByPrimaryKeySelective(userDO);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public BizResult queryUserDOByEmail(String email) {
        BizResult<UserDO> bizResult = new BizResult<UserDO>();
        if(email!=null){
            UserQuery query = new UserQuery();
            query.createCriteria().andEmailEqualTo(email);
            List<UserDO> userDOs = userManager.selectByQuery(query);
            if(userDOs.size()>0){
                bizResult.setSuccess(true);
                bizResult.setResult(userDOs.get(0));
            }else{
                bizResult.setSuccess(false);
            }
        }else{
            bizResult.setSuccess(false);
        }
        return bizResult;
    }

}
