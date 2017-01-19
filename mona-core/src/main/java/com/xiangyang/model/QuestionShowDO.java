package com.xiangyang.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

public class QuestionShowDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column mona_question_show.question_id
     */
    private Long questionId;

    /**
     * This field corresponds to the database column mona_question_show.question_title
     */
    private String questionTitle;

    /**
     * This field corresponds to the database column mona_question_show.question_author_id
     */
    private Long questionAuthorId;

    /**
     * This field corresponds to the database column mona_question_show.question_description
     */
    private String questionDescription;

    /**
     * This field corresponds to the database column mona_question_show.product_id
     */
    private Long productId;

    /**
     * This field corresponds to the database column mona_question_show.question_level
     */
    private Integer questionLevel;

    /**
     * This field corresponds to the database column mona_question_show.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column mona_question_show.gmt_modified
     */
    private Date gmtModified;

    /**
     * This field corresponds to the database column mona_question_show.is_deleted
     */
    private Integer isDeleted;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Long getQuestionAuthorId() {
		return questionAuthorId;
	}

	public void setQuestionAuthorId(Long questionAuthorId) {
		this.questionAuthorId = questionAuthorId;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuestionLevel() {
		return questionLevel;
	}

	public void setQuestionLevel(Integer questionLevel) {
		this.questionLevel = questionLevel;
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