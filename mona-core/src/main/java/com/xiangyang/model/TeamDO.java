package com.xiangyang.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

public class TeamDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column mona_team.team_id
     */
    private Long teamId;

    /**
     * This field corresponds to the database column mona_team.team_name
     */
    private String teamName;

    /**
     * This field corresponds to the database column mona_team.team_dec
     */
    private String teamDec;

    /**
     * This field corresponds to the database column mona_team.gmt_modified
     */
    private Date gmtModified;

    /**
     * This field corresponds to the database column mona_team.gmt_create
     */
    private Date gmtCreate;

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamDec() {
		return teamDec;
	}

	public void setTeamDec(String teamDec) {
		this.teamDec = teamDec;
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