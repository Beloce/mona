package com.xiangyang.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column mona_user.user_id
     */
    private Long userId;

    /**
     * This field corresponds to the database column mona_user.email
     */
    private String email;

    /**
     * This field corresponds to the database column mona_user.password
     */
    private String password;

    /**
     * This field corresponds to the database column mona_user.real_name
     */
    private String realName;

    /**
     * This field corresponds to the database column mona_user.flower_name
     */
    private String flowerName;

    /**
     * This field corresponds to the database column mona_user.department_id
     */
    private Long departmentId;

    /**
     * This field corresponds to the database column mona_user.head_img
     */
    private String headImg;

    /**
     * This field corresponds to the database column mona_user.mobile
     */
    private String mobile;

    /**
     * This field corresponds to the database column mona_user.role
     */
    private Integer role;

    /**
     * This field corresponds to the database column mona_user.job_number
     */
    private Integer jobNumber;

    /**
     * This field corresponds to the database column mona_user.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column mona_user.gmt_modified
     */
    private Date gmtModified;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(Integer jobNumber) {
		this.jobNumber = jobNumber;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}


    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}