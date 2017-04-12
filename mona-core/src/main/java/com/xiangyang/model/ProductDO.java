package com.xiangyang.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

public class ProductDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column mona_product.product_id
     */
    private Long productId;

    /**
     * This field corresponds to the database column mona_product.product_name
     */
    private String productName;

    /**
     * This field corresponds to the database column mona_product.product_desc
     */
    private String productDesc;

    /**
     * This field corresponds to the database column mona_product.status
     */
    private Integer status;

    /**
     * This field corresponds to the database column mona_product.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column mona_product.gmt_modified
     */
    private Date gmtModified;

    /**
     * This field corresponds to the database column mona_product.team_id
     */
    private Long teamId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}


    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}