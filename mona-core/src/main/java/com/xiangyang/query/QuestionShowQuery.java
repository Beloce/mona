package com.xiangyang.query;


import com.xiangyang.util.query.support.BaseQuery;
import com.xiangyang.util.query.support.BaseCriteria;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionShowQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    public QuestionShowQuery() {
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
     * This class corresponds to the database table mona_question_show
     */
         protected abstract static class GeneratedCriteria extends BaseCriteria {

        protected GeneratedCriteria() {
            super();
        }

        public Criteria andQuestionIdIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Long value) {
            addCriterion("question_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Long value) {
            addCriterion("question_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria anQuestionIdGreaterThan(Long value) {
            addCriterion("question_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("question_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Long value) {
            addCriterion("question_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Long value) {
            addCriterion("question_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Long> values) {
            addCriterion("question_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Long> values) {
            addCriterion("question_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Long value1, Long value2) {
            addCriterion("question_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Long value1, Long value2) {
            addCriterion("question_id not between", value1, value2, "id");
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

        public Criteria andQuestionTitleIsNull() {
            addCriterion("question_title is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleIsNotNull() {
            addCriterion("question_title is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleEqualTo(String value) {
            addCriterion("question_title =", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotEqualTo(String value) {
            addCriterion("question_title <>", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleGreaterThan(String value) {
            addCriterion("question_title >", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleGreaterThanOrEqualTo(String value) {
            addCriterion("question_title >=", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLessThan(String value) {
            addCriterion("question_title <", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLessThanOrEqualTo(String value) {
            addCriterion("question_title <=", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLike(String value) {
            addCriterion("question_title like", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotLike(String value) {
            addCriterion("question_title not like", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleIn(List<String> values) {
            addCriterion("question_title in", values, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotIn(List<String> values) {
            addCriterion("question_title not in", values, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleBetween(String value1, String value2) {
            addCriterion("question_title between", value1, value2, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotBetween(String value1, String value2) {
            addCriterion("question_title not between", value1, value2, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdIsNull() {
            addCriterion("question_author_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdIsNotNull() {
            addCriterion("question_author_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdEqualTo(Long value) {
            addCriterion("question_author_id =", value, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdNotEqualTo(Long value) {
            addCriterion("question_author_id <>", value, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdGreaterThan(Long value) {
            addCriterion("question_author_id >", value, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("question_author_id >=", value, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdLessThan(Long value) {
            addCriterion("question_author_id <", value, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdLessThanOrEqualTo(Long value) {
            addCriterion("question_author_id <=", value, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdLike(Long value) {
            addCriterion("question_author_id like", value, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdNotLike(Long value) {
            addCriterion("question_author_id not like", value, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdIn(List<Long> values) {
            addCriterion("question_author_id in", values, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdNotIn(List<Long> values) {
            addCriterion("question_author_id not in", values, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdBetween(Long value1, Long value2) {
            addCriterion("question_author_id between", value1, value2, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionAuthorIdNotBetween(Long value1, Long value2) {
            addCriterion("question_author_id not between", value1, value2, "questionAuthorId");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionIsNull() {
            addCriterion("question_description is null");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionIsNotNull() {
            addCriterion("question_description is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionEqualTo(String value) {
            addCriterion("question_description =", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionNotEqualTo(String value) {
            addCriterion("question_description <>", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionGreaterThan(String value) {
            addCriterion("question_description >", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("question_description >=", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionLessThan(String value) {
            addCriterion("question_description <", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionLessThanOrEqualTo(String value) {
            addCriterion("question_description <=", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionLike(String value) {
            addCriterion("question_description like", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionNotLike(String value) {
            addCriterion("question_description not like", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionIn(List<String> values) {
            addCriterion("question_description in", values, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionNotIn(List<String> values) {
            addCriterion("question_description not in", values, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionBetween(String value1, String value2) {
            addCriterion("question_description between", value1, value2, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionNotBetween(String value1, String value2) {
            addCriterion("question_description not between", value1, value2, "questionDescription");
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

        public Criteria andQuestionLevelIsNull() {
            addCriterion("question_level is null");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelIsNotNull() {
            addCriterion("question_level is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelEqualTo(Integer value) {
            addCriterion("question_level =", value, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelNotEqualTo(Integer value) {
            addCriterion("question_level <>", value, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelGreaterThan(Integer value) {
            addCriterion("question_level >", value, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_level >=", value, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelLessThan(Integer value) {
            addCriterion("question_level <", value, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelLessThanOrEqualTo(Integer value) {
            addCriterion("question_level <=", value, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelLike(Integer value) {
            addCriterion("question_level like", value, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelNotLike(Integer value) {
            addCriterion("question_level not like", value, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelIn(List<Integer> values) {
            addCriterion("question_level in", values, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelNotIn(List<Integer> values) {
            addCriterion("question_level not in", values, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelBetween(Integer value1, Integer value2) {
            addCriterion("question_level between", value1, value2, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andQuestionLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("question_level not between", value1, value2, "questionLevel");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Integer value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Integer value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Integer value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Integer value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(Integer value) {
            addCriterion("is_deleted like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(Integer value) {
            addCriterion("is_deleted not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Integer> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Integer> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table mona_question_show
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