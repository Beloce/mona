package com.xiangyang.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

public class ProjectDepartmentDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column mona_project_department.pro_depart_id
     */
    private Long proDepartId;

    /**
     * This field corresponds to the database column mona_project_department.department_id
     */
    private Long departmentId;

    /**
     * This field corresponds to the database column mona_project_department.project_id
     */
    private Long projectId;

    /**
     * This field corresponds to the database column mona_project_department.gmt_create
     */
    private java.sql.Date gmtCreate;

    /**
     * This field corresponds to the database column mona_project_department.gmt_modified
     */
    private java.sql.Date gmtModified;

    /**
     * This field corresponds to the database column mona_project_department.is_deleted
     */
    private Integer isDeleted;

	public Long getProDepartId() {
		return proDepartId;
	}

	public void setProDepartId(Long proDepartId) {
		this.proDepartId = proDepartId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public java.sql.Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(java.sql.Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public java.sql.Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(java.sql.Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}


    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}