package com.xiangyang.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

public class ErrorDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column mona_error.error_id
     */
    private Long errorId;

    /**
     * This field corresponds to the database column mona_error.product_id
     */
    private Long productId;

    /**
     * This field corresponds to the database column mona_error.title
     */
    private String title;

    /**
     * This field corresponds to the database column mona_error.description
     */
    private String description;

    /**
     * This field corresponds to the database column mona_error.screenshot
     */
    private String screenshot;

    /**
     * This field corresponds to the database column mona_error.source
     */
    private Integer source;

    /**
     * This field corresponds to the database column mona_error.type
     */
    private Integer type;

    /**
     * This field corresponds to the database column mona_error.status
     */
    private Integer status;

    /**
     * This field corresponds to the database column mona_error.reason
     */
    private String reason;

    /**
     * This field corresponds to the database column mona_error.responsibility
     */
    private Integer responsibility;

    /**
     * This field corresponds to the database column mona_error.resolve_type
     */
    private Integer resolveType;

    /**
     * This field corresponds to the database column mona_error.provider_id
     */
    private Long providerId;

    /**
     * This field corresponds to the database column mona_error.gmt_modified
     */
    private Date gmtModified;

    /**
     * This field corresponds to the database column mona_error.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column mona_error.appraise_level
     */
    private Integer appraiseLevel;

	public Long getErrorId() {
		return errorId;
	}

	public void setErrorId(Long errorId) {
		this.errorId = errorId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScreenshot() {
		return screenshot;
	}

	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(Integer responsibility) {
		this.responsibility = responsibility;
	}

	public Integer getResolveType() {
		return resolveType;
	}

	public void setResolveType(Integer resolveType) {
		this.resolveType = resolveType;
	}

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
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

	public Integer getAppraiseLevel() {
		return appraiseLevel;
	}

	public void setAppraiseLevel(Integer appraiseLevel) {
		this.appraiseLevel = appraiseLevel;
	}


    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}