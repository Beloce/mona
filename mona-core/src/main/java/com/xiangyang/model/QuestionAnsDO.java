package com.xiangyang.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

public class QuestionAnsDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column mona_question_ans.qa_id
     */
    private Long qaId;

    /**
     * This field corresponds to the database column mona_question_ans.asker_id
     */
    private Long askerId;

    /**
     * This field corresponds to the database column mona_question_ans.answerer_id
     */
    private Long answererId;

    /**
     * This field corresponds to the database column mona_question_ans.qa_title
     */
    private String qaTitle;

    /**
     * This field corresponds to the database column mona_question_ans.qa_content
     */
    private String qaContent;

    /**
     * This field corresponds to the database column mona_question_ans.product_id
     */
    private Long productId;

    /**
     * This field corresponds to the database column mona_question_ans.gmtcreate
     */
    private java.sql.Date gmtcreate;

    /**
     * This field corresponds to the database column mona_question_ans.gmtmodified
     */
    private java.sql.Date gmtmodified;

    /**
     * This field corresponds to the database column mona_question_ans.istop
     */
    private Integer istop;

    /**
     * This field corresponds to the database column mona_question_ans.issolve
     */
    private Integer issolve;

    /**
     * This field corresponds to the database column mona_question_ans.isdeleted
     */
    private Integer isdeleted;

    /**
     * This field corresponds to the database column mona_question_ans.father_id
     */
    private Long fatherId;

	public Long getQaId() {
		return qaId;
	}

	public void setQaId(Long qaId) {
		this.qaId = qaId;
	}

	public Long getAskerId() {
		return askerId;
	}

	public void setAskerId(Long askerId) {
		this.askerId = askerId;
	}

	public Long getAnswererId() {
		return answererId;
	}

	public void setAnswererId(Long answererId) {
		this.answererId = answererId;
	}

	public String getQaTitle() {
		return qaTitle;
	}

	public void setQaTitle(String qaTitle) {
		this.qaTitle = qaTitle;
	}

	public String getQaContent() {
		return qaContent;
	}

	public void setQaContent(String qaContent) {
		this.qaContent = qaContent;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public java.sql.Date getGmtcreate() {
		return gmtcreate;
	}

	public void setGmtcreate(java.sql.Date gmtcreate) {
		this.gmtcreate = gmtcreate;
	}

	public java.sql.Date getGmtmodified() {
		return gmtmodified;
	}

	public void setGmtmodified(java.sql.Date gmtmodified) {
		this.gmtmodified = gmtmodified;
	}

	public Integer getIstop() {
		return istop;
	}

	public void setIstop(Integer istop) {
		this.istop = istop;
	}

	public Integer getIssolve() {
		return issolve;
	}

	public void setIssolve(Integer issolve) {
		this.issolve = issolve;
	}

	public Integer getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Integer isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Long getFatherId() {
		return fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}


    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}