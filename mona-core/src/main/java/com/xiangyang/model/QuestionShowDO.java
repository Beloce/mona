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
     * This field corresponds to the database column mona_question_show.title
     */
    private String title;

    /**
     * This field corresponds to the database column mona_question_show.author_id
     */
    private Long authorId;

    /**
     * This field corresponds to the database column mona_question_show.description
     */
    private String description;

    /**
     * This field corresponds to the database column mona_question_show.product_id
     */
    private Long productId;

    /**
     * This field corresponds to the database column mona_question_show.status
     */
    private Integer status;

    /**
     * This field corresponds to the database column mona_question_show.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column mona_question_show.gmt_modified
     */
    private Date gmtModified;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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


    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}