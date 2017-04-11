package com.xiangyang.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

public class ErrorRecordDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column mona_error_record.record_id
     */
    private Long recordId;

    /**
     * This field corresponds to the database column mona_error_record.error_id
     */
    private Long errorId;

    /**
     * This field corresponds to the database column mona_error_record.operation_type
     */
    private Integer operationType;

    /**
     * This field corresponds to the database column mona_error_record.operator_id
     */
    private Long operatorId;

    /**
     * This field corresponds to the database column mona_error_record.replacement_id
     */
    private Long replacementId;

    /**
     * This field corresponds to the database column mona_error_record.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column mona_error_record.gmt_modified
     */
    private Date gmtModified;

    /**
     * This field corresponds to the database column mona_error_record.status
     */
    private Integer status;

    /**
     * This field corresponds to the database column mona_error_record.memo
     */
    private String memo;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getErrorId() {
		return errorId;
	}

	public void setErrorId(Long errorId) {
		this.errorId = errorId;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public Long getReplacementId() {
		return replacementId;
	}

	public void setReplacementId(Long replacementId) {
		this.replacementId = replacementId;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}


    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}