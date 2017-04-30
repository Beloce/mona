package com.xiangyang.query;


import com.xiangyang.util.query.support.BaseQuery;
import com.xiangyang.util.query.support.BaseCriteria;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorRecordQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    public ErrorRecordQuery() {
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
     * This class corresponds to the database table mona_error_record
     */
         protected abstract static class GeneratedCriteria extends BaseCriteria {

        protected GeneratedCriteria() {
            super();
        }

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Long value) {
            addCriterion("record_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Long value) {
            addCriterion("record_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria anRecordIdGreaterThan(Long value) {
            addCriterion("record_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("record_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Long value) {
            addCriterion("record_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("record_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Long> values) {
            addCriterion("record_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Long> values) {
            addCriterion("record_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Long value1, Long value2) {
            addCriterion("record_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("record_id not between", value1, value2, "id");
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

        public Criteria andErrorIdIsNull() {
            addCriterion("error_id is null");
            return (Criteria) this;
        }

        public Criteria andErrorIdIsNotNull() {
            addCriterion("error_id is not null");
            return (Criteria) this;
        }

        public Criteria andErrorIdEqualTo(Long value) {
            addCriterion("error_id =", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdNotEqualTo(Long value) {
            addCriterion("error_id <>", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdGreaterThan(Long value) {
            addCriterion("error_id >", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("error_id >=", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdLessThan(Long value) {
            addCriterion("error_id <", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdLessThanOrEqualTo(Long value) {
            addCriterion("error_id <=", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdLike(Long value) {
            addCriterion("error_id like", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdNotLike(Long value) {
            addCriterion("error_id not like", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdIn(List<Long> values) {
            addCriterion("error_id in", values, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdNotIn(List<Long> values) {
            addCriterion("error_id not in", values, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdBetween(Long value1, Long value2) {
            addCriterion("error_id between", value1, value2, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdNotBetween(Long value1, Long value2) {
            addCriterion("error_id not between", value1, value2, "errorId");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNull() {
            addCriterion("operation_type is null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNotNull() {
            addCriterion("operation_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeEqualTo(Integer value) {
            addCriterion("operation_type =", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotEqualTo(Integer value) {
            addCriterion("operation_type <>", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThan(Integer value) {
            addCriterion("operation_type >", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_type >=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThan(Integer value) {
            addCriterion("operation_type <", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("operation_type <=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLike(Integer value) {
            addCriterion("operation_type like", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotLike(Integer value) {
            addCriterion("operation_type not like", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIn(List<Integer> values) {
            addCriterion("operation_type in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotIn(List<Integer> values) {
            addCriterion("operation_type not in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeBetween(Integer value1, Integer value2) {
            addCriterion("operation_type between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_type not between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Long value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Long value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Long value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Long value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLike(Long value) {
            addCriterion("operator_id like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotLike(Long value) {
            addCriterion("operator_id not like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Long> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Long> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Long value1, Long value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdIsNull() {
            addCriterion("original_product_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdIsNotNull() {
            addCriterion("original_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdEqualTo(Long value) {
            addCriterion("original_product_id =", value, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdNotEqualTo(Long value) {
            addCriterion("original_product_id <>", value, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdGreaterThan(Long value) {
            addCriterion("original_product_id >", value, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("original_product_id >=", value, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdLessThan(Long value) {
            addCriterion("original_product_id <", value, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdLessThanOrEqualTo(Long value) {
            addCriterion("original_product_id <=", value, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdLike(Long value) {
            addCriterion("original_product_id like", value, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdNotLike(Long value) {
            addCriterion("original_product_id not like", value, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdIn(List<Long> values) {
            addCriterion("original_product_id in", values, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdNotIn(List<Long> values) {
            addCriterion("original_product_id not in", values, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdBetween(Long value1, Long value2) {
            addCriterion("original_product_id between", value1, value2, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andOriginalProductIdNotBetween(Long value1, Long value2) {
            addCriterion("original_product_id not between", value1, value2, "originalProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdIsNull() {
            addCriterion("replace_product_id is null");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdIsNotNull() {
            addCriterion("replace_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdEqualTo(Long value) {
            addCriterion("replace_product_id =", value, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdNotEqualTo(Long value) {
            addCriterion("replace_product_id <>", value, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdGreaterThan(Long value) {
            addCriterion("replace_product_id >", value, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("replace_product_id >=", value, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdLessThan(Long value) {
            addCriterion("replace_product_id <", value, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdLessThanOrEqualTo(Long value) {
            addCriterion("replace_product_id <=", value, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdLike(Long value) {
            addCriterion("replace_product_id like", value, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdNotLike(Long value) {
            addCriterion("replace_product_id not like", value, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdIn(List<Long> values) {
            addCriterion("replace_product_id in", values, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdNotIn(List<Long> values) {
            addCriterion("replace_product_id not in", values, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdBetween(Long value1, Long value2) {
            addCriterion("replace_product_id between", value1, value2, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andReplaceProductIdNotBetween(Long value1, Long value2) {
            addCriterion("replace_product_id not between", value1, value2, "replaceProductId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(Integer value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(Integer value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table mona_error_record
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