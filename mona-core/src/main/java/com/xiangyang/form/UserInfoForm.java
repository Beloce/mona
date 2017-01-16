package com.xiangyang.form;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiangyang on 16/11/10.
 */
@Data
public class UserInfoForm implements Serializable{

    private Long userId;

    private String email;

    private String password;

    private String realName;

    private String flowerName;

    private Integer departmentId;

    private String headImg;

    private String mobile;

    private Integer jobNumber;

}
