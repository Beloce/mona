package com.xiangyang.query;


import com.xiangyang.util.query.support.BaseQuery;
import com.xiangyang.util.query.support.BaseCriteria;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionAnsQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    public QuestionAnsQuery() {
        super();
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        super.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This class corresponds to the database table mona_question_ans
     */
         protected abstract static class GeneratedCriteria extends BaseCriteria {

        protected GeneratedCriteria() {
            super();
        }

        public Criteria andQaIdIsNull() {
            addCriterion("qa_id is null");
            return (Criteria) this;
        }

        public Criteria andQaIdIsNotNull() {
            addCriterion("qa_id is not null");
            return (Criteria) this;
        }

        public Criteria andQaIdEqualTo(Long value) {
            addCriterion("qa_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andQaIdNotEqualTo(Long value) {
            addCriterion("qa_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria anQaIdGreaterThan(Long value) {
            addCriterion("qa_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andQaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("qa_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andQaIdLessThan(Long value) {
            addCriterion("qa_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andQaIdLessThanOrEqualTo(Long value) {
            addCriterion("qa_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andQaIdIn(List<Long> values) {
            addCriterion("qa_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andQaIdNotIn(List<Long> values) {
            addCriterion("qa_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andQaIdBetween(Long value1, Long value2) {
            addCriterion("qa_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQaIdNotBetween(Long value1, Long value2) {
            addCriterion("qa_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andAskerIdIsNull() {
            addCriterion("asker_id is null");
            return (Criteria) this;
        }

        public Criteria andAskerIdIsNotNull() {
            addCriterion("asker_id is not null");
            return (Criteria) this;
        }

        public Criteria andAskerIdEqualTo(Long value) {
            addCriterion("asker_id =", value, "askerId");
            return (Criteria) this;
        }

        public Criteria andAskerIdNotEqualTo(Long value) {
            addCriterion("asker_id <>", value, "askerId");
            return (Criteria) this;
        }

        public Criteria andAskerIdGreaterThan(Long value) {
            addCriterion("asker_id >", value, "askerId");
            return (Criteria) this;
        }

        public Criteria andAskerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("asker_id >=", value, "askerId");
            return (Criteria) this;
        }

        public Criteria andAskerIdLessThan(Long value) {
            addCriterion("asker_id <", value, "askerId");
            return (Criteria) this;
        }

        public Criteria andAskerIdLessThanOrEqualTo(Long value) {
            addCriterion("asker_id <=", value, "askerId");
            return (Criteria) this;
        }

        public Criteria andAskerIdLike(Long value) {
            addCriterion("asker_id like", value, "askerId");
            return (Criteria) this;
        }

        public Criteria andAskerIdNotLike(Long value) {
            addCriterion("asker_id not like", value, "askerId");
            return (Criteria) this;
        }

        public Criteria andAskerIdIn(List<Long> values) {
            addCriterion("asker_id in", values, "askerId");
            return (Criteria) this;
        }

        public Criteria andAskerIdNotIn(List<Long> values) {
            addCriterion("asker_id not in", values, "askerId");
            return (Criteria) this;
        }

        public Criteria andAskerIdBetween(Long value1, Long value2) {
            addCriterion("asker_id between", value1, value2, "askerId");
            return (Criteria) this;
        }

        public Criteria andAskerIdNotBetween(Long value1, Long value2) {
            addCriterion("asker_id not between", value1, value2, "askerId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdIsNull() {
            addCriterion("answerer_id is null");
            return (Criteria) this;
        }

        public Criteria andAnswererIdIsNotNull() {
            addCriterion("answerer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnswererIdEqualTo(Long value) {
            addCriterion("answerer_id =", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdNotEqualTo(Long value) {
            addCriterion("answerer_id <>", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdGreaterThan(Long value) {
            addCriterion("answerer_id >", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdGreaterThanOrEqualTo(Long value) {
            addCriterion("answerer_id >=", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdLessThan(Long value) {
            addCriterion("answerer_id <", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdLessThanOrEqualTo(Long value) {
            addCriterion("answerer_id <=", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdLike(Long value) {
            addCriterion("answerer_id like", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdNotLike(Long value) {
            addCriterion("answerer_id not like", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdIn(List<Long> values) {
            addCriterion("answerer_id in", values, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdNotIn(List<Long> values) {
            addCriterion("answerer_id not in", values, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdBetween(Long value1, Long value2) {
            addCriterion("answerer_id between", value1, value2, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdNotBetween(Long value1, Long value2) {
            addCriterion("answerer_id not between", value1, value2, "answererId");
            return (Criteria) this;
        }

        public Criteria andQaTitleIsNull() {
            addCriterion("qa_title is null");
            return (Criteria) this;
        }

        public Criteria andQaTitleIsNotNull() {
            addCriterion("qa_title is not null");
            return (Criteria) this;
        }

        public Criteria andQaTitleEqualTo(String value) {
            addCriterion("qa_title =", value, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaTitleNotEqualTo(String value) {
            addCriterion("qa_title <>", value, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaTitleGreaterThan(String value) {
            addCriterion("qa_title >", value, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaTitleGreaterThanOrEqualTo(String value) {
            addCriterion("qa_title >=", value, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaTitleLessThan(String value) {
            addCriterion("qa_title <", value, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaTitleLessThanOrEqualTo(String value) {
            addCriterion("qa_title <=", value, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaTitleLike(String value) {
            addCriterion("qa_title like", value, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaTitleNotLike(String value) {
            addCriterion("qa_title not like", value, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaTitleIn(List<String> values) {
            addCriterion("qa_title in", values, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaTitleNotIn(List<String> values) {
            addCriterion("qa_title not in", values, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaTitleBetween(String value1, String value2) {
            addCriterion("qa_title between", value1, value2, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaTitleNotBetween(String value1, String value2) {
            addCriterion("qa_title not between", value1, value2, "qaTitle");
            return (Criteria) this;
        }

        public Criteria andQaContentIsNull() {
            addCriterion("qa_content is null");
            return (Criteria) this;
        }

        public Criteria andQaContentIsNotNull() {
            addCriterion("qa_content is not null");
            return (Criteria) this;
        }

        public Criteria andQaContentEqualTo(String value) {
            addCriterion("qa_content =", value, "qaContent");
            return (Criteria) this;
        }

        public Criteria andQaContentNotEqualTo(String value) {
            addCriterion("qa_content <>", value, "qaContent");
            return (Criteria) this;
        }

        public Criteria andQaContentGreaterThan(String value) {
            addCriterion("qa_content >", value, "qaContent");
            return (Criteria) this;
        }

        public Criteria andQaContentGreaterThanOrEqualTo(String value) {
            addCriterion("qa_content >=", value, "qaContent");
            return (Criteria) this;
        }

        public Criteria andQaContentLessThan(String value) {
            addCriterion("qa_content <", value, "qaContent");
            return (Criteria) this;
        }

        public Criteria andQaContentLessThanOrEqualTo(String value) {
            addCriterion("qa_content <=", value, "qaContent");
            return (Criteria) this;
        }

        public Criteria andQaContentLike(String value) {
            addCriterion("qa_content like", value, "qaContent");
            return (Criteria) this;
        }

        public Criteria andQaContentNotLike(String value) {
            addCriterion("qa_content not like", value, "qaContent");
            return (Criteria) this;
        }

        public Criteria andQaContentIn(List<String> values) {
            addCriterion("qa_content in", values, "qaContent");
            return (Criteria) this;
        }

        public Criteria andQaContentNotIn(List<String> values) {
            addCriterion("qa_content not in", values, "qaContent");
            return (Criteria) this;
        }

        public Criteria andQaContentBetween(String value1, String value2) {
            addCriterion("qa_content between", value1, value2, "qaContent");
            return (Criteria) this;
        }

        public Criteria andQaContentNotBetween(String value1, String value2) {
            addCriterion("qa_content not between", value1, value2, "qaContent");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(Long value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(Long value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andGmtcreateIsNull() {
            addCriterion("gmtcreate is null");
            return (Criteria) this;
        }

        public Criteria andGmtcreateIsNotNull() {
            addCriterion("gmtcreate is not null");
            return (Criteria) this;
        }

        public Criteria andGmtcreateEqualTo(java.sql.Date value) {
            addCriterion("gmtcreate =", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateNotEqualTo(java.sql.Date value) {
            addCriterion("gmtcreate <>", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateGreaterThan(java.sql.Date value) {
            addCriterion("gmtcreate >", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateGreaterThanOrEqualTo(java.sql.Date value) {
            addCriterion("gmtcreate >=", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateLessThan(java.sql.Date value) {
            addCriterion("gmtcreate <", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateLessThanOrEqualTo(java.sql.Date value) {
            addCriterion("gmtcreate <=", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateLike(java.sql.Date value) {
            addCriterion("gmtcreate like", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateNotLike(java.sql.Date value) {
            addCriterion("gmtcreate not like", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateIn(List<java.sql.Date> values) {
            addCriterion("gmtcreate in", values, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateNotIn(List<java.sql.Date> values) {
            addCriterion("gmtcreate not in", values, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateBetween(java.sql.Date value1, java.sql.Date value2) {
            addCriterion("gmtcreate between", value1, value2, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateNotBetween(java.sql.Date value1, java.sql.Date value2) {
            addCriterion("gmtcreate not between", value1, value2, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedIsNull() {
            addCriterion("gmtmodified is null");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedIsNotNull() {
            addCriterion("gmtmodified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedEqualTo(java.sql.Date value) {
            addCriterion("gmtmodified =", value, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedNotEqualTo(java.sql.Date value) {
            addCriterion("gmtmodified <>", value, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedGreaterThan(java.sql.Date value) {
            addCriterion("gmtmodified >", value, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedGreaterThanOrEqualTo(java.sql.Date value) {
            addCriterion("gmtmodified >=", value, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedLessThan(java.sql.Date value) {
            addCriterion("gmtmodified <", value, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedLessThanOrEqualTo(java.sql.Date value) {
            addCriterion("gmtmodified <=", value, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedLike(java.sql.Date value) {
            addCriterion("gmtmodified like", value, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedNotLike(java.sql.Date value) {
            addCriterion("gmtmodified not like", value, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedIn(List<java.sql.Date> values) {
            addCriterion("gmtmodified in", values, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedNotIn(List<java.sql.Date> values) {
            addCriterion("gmtmodified not in", values, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedBetween(java.sql.Date value1, java.sql.Date value2) {
            addCriterion("gmtmodified between", value1, value2, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andGmtmodifiedNotBetween(java.sql.Date value1, java.sql.Date value2) {
            addCriterion("gmtmodified not between", value1, value2, "gmtmodified");
            return (Criteria) this;
        }

        public Criteria andIstopIsNull() {
            addCriterion("istop is null");
            return (Criteria) this;
        }

        public Criteria andIstopIsNotNull() {
            addCriterion("istop is not null");
            return (Criteria) this;
        }

        public Criteria andIstopEqualTo(Integer value) {
            addCriterion("istop =", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotEqualTo(Integer value) {
            addCriterion("istop <>", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThan(Integer value) {
            addCriterion("istop >", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThanOrEqualTo(Integer value) {
            addCriterion("istop >=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThan(Integer value) {
            addCriterion("istop <", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThanOrEqualTo(Integer value) {
            addCriterion("istop <=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLike(Integer value) {
            addCriterion("istop like", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotLike(Integer value) {
            addCriterion("istop not like", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopIn(List<Integer> values) {
            addCriterion("istop in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotIn(List<Integer> values) {
            addCriterion("istop not in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopBetween(Integer value1, Integer value2) {
            addCriterion("istop between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotBetween(Integer value1, Integer value2) {
            addCriterion("istop not between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andIssolveIsNull() {
            addCriterion("issolve is null");
            return (Criteria) this;
        }

        public Criteria andIssolveIsNotNull() {
            addCriterion("issolve is not null");
            return (Criteria) this;
        }

        public Criteria andIssolveEqualTo(Integer value) {
            addCriterion("issolve =", value, "issolve");
            return (Criteria) this;
        }

        public Criteria andIssolveNotEqualTo(Integer value) {
            addCriterion("issolve <>", value, "issolve");
            return (Criteria) this;
        }

        public Criteria andIssolveGreaterThan(Integer value) {
            addCriterion("issolve >", value, "issolve");
            return (Criteria) this;
        }

        public Criteria andIssolveGreaterThanOrEqualTo(Integer value) {
            addCriterion("issolve >=", value, "issolve");
            return (Criteria) this;
        }

        public Criteria andIssolveLessThan(Integer value) {
            addCriterion("issolve <", value, "issolve");
            return (Criteria) this;
        }

        public Criteria andIssolveLessThanOrEqualTo(Integer value) {
            addCriterion("issolve <=", value, "issolve");
            return (Criteria) this;
        }

        public Criteria andIssolveLike(Integer value) {
            addCriterion("issolve like", value, "issolve");
            return (Criteria) this;
        }

        public Criteria andIssolveNotLike(Integer value) {
            addCriterion("issolve not like", value, "issolve");
            return (Criteria) this;
        }

        public Criteria andIssolveIn(List<Integer> values) {
            addCriterion("issolve in", values, "issolve");
            return (Criteria) this;
        }

        public Criteria andIssolveNotIn(List<Integer> values) {
            addCriterion("issolve not in", values, "issolve");
            return (Criteria) this;
        }

        public Criteria andIssolveBetween(Integer value1, Integer value2) {
            addCriterion("issolve between", value1, value2, "issolve");
            return (Criteria) this;
        }

        public Criteria andIssolveNotBetween(Integer value1, Integer value2) {
            addCriterion("issolve not between", value1, value2, "issolve");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIsNull() {
            addCriterion("isdeleted is null");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIsNotNull() {
            addCriterion("isdeleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeletedEqualTo(Integer value) {
            addCriterion("isdeleted =", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotEqualTo(Integer value) {
            addCriterion("isdeleted <>", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedGreaterThan(Integer value) {
            addCriterion("isdeleted >", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdeleted >=", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLessThan(Integer value) {
            addCriterion("isdeleted <", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLessThanOrEqualTo(Integer value) {
            addCriterion("isdeleted <=", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLike(Integer value) {
            addCriterion("isdeleted like", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotLike(Integer value) {
            addCriterion("isdeleted not like", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIn(List<Integer> values) {
            addCriterion("isdeleted in", values, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotIn(List<Integer> values) {
            addCriterion("isdeleted not in", values, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedBetween(Integer value1, Integer value2) {
            addCriterion("isdeleted between", value1, value2, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("isdeleted not between", value1, value2, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andFatherIdIsNull() {
            addCriterion("father_id is null");
            return (Criteria) this;
        }

        public Criteria andFatherIdIsNotNull() {
            addCriterion("father_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatherIdEqualTo(Long value) {
            addCriterion("father_id =", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotEqualTo(Long value) {
            addCriterion("father_id <>", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdGreaterThan(Long value) {
            addCriterion("father_id >", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdGreaterThanOrEqualTo(Long value) {
            addCriterion("father_id >=", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLessThan(Long value) {
            addCriterion("father_id <", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLessThanOrEqualTo(Long value) {
            addCriterion("father_id <=", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLike(Long value) {
            addCriterion("father_id like", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotLike(Long value) {
            addCriterion("father_id not like", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdIn(List<Long> values) {
            addCriterion("father_id in", values, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotIn(List<Long> values) {
            addCriterion("father_id not in", values, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdBetween(Long value1, Long value2) {
            addCriterion("father_id between", value1, value2, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotBetween(Long value1, Long value2) {
            addCriterion("father_id not between", value1, value2, "fatherId");
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table mona_question_ans
    */
    public  static class Criteria extends GeneratedCriteria{
        protected Criteria() {
            super();
        }
    }



    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}