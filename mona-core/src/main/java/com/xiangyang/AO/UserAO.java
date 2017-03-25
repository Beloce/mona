package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.form.UserInfoForm;
import com.xiangyang.model.DepartmentDO;
import com.xiangyang.model.UserDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiangyang on 16/11/10.
 */
public interface UserAO {

    /**
     * 根据email邮箱查询用户信息
     * @param email
     * @return BizResult(UserInfoForm,true or false)
     */
     BizResult getUserInfoByEmail(String email);

    /**
     * 根据UserInfoForm来更新用户信息,用于用户自己更新信息(电话和头像）
     * @param userInfoForm
     * @return
     */
     BizResult updateUserInfoByUserInfoForm(UserInfoForm userInfoForm);

    /**
     * 根据email来查询userDO
     * @param email
     * @return
     */
    UserDO selectUserByEmail(String email);

    /**
     * 根据UserDO跟新user
     * @param userDO
     * @return
     */
    boolean updateUserByUserDO(UserDO userDO);

    /**
     * 根据email来获取userDO
     * @param email
     * @return
     */
    BizResult queryUserDOByEmail(String email);

    /**
     * 根据部门编号来获取用户
     * @param departmentId
     * @return
     */
    List<UserDO> queryUserDOsByDepartmentId(Long departmentId);
}
