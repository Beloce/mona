package com.xiangyang.dto;

import com.xiangyang.form.DepartmentForm;
import com.xiangyang.form.UserInfoForm;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by peiji on 2016/11/27.
 */
@Data
public class UserInfoDTO implements Serializable {
    UserInfoForm userInfoForm;
    DepartmentForm departmentForm;
}
