package com.xiangyang.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

public class ProjectDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column mona_project.project_id
     */
    private Long projectId;

    /**
     * This field corresponds to the database column mona_project.father_project_id
     */
    private String fatherProjectId;

    /**
     * This field corresponds to the database column mona_project.project_level
     */
    private Integer projectLevel;

    /**
     * This field corresponds to the database column mona_project.project_name
     */
    private String projectName;

    /**
     * This field corresponds to the database column mona_project.gmt_modified
     */
    private Date gmtModified;

    /**
     * This field corresponds to the database column mona_project.gmt_create
     */
    private Date gmtCreate;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getFatherProjectId() {
		return fatherProjectId;
	}

	public void setFatherProjectId(String fatherProjectId) {
		this.fatherProjectId = fatherProjectId;
	}

	public Integer getProjectLevel() {
		return projectLevel;
	}

	public void setProjectLevel(Integer projectLevel) {
		this.projectLevel = projectLevel;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}


    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}