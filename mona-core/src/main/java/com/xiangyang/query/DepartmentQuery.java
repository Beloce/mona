package com.xiangyang.query;


import com.xiangyang.util.query.support.BaseQuery;
import com.xiangyang.util.query.support.BaseCriteria;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    public DepartmentQuery() {
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
     * This class corresponds to the database table mona_department
     */
         protected abstract static class GeneratedCriteria extends BaseCriteria {

        protected GeneratedCriteria() {
            super();
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Long value) {
            addCriterion("department_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Long value) {
            addCriterion("department_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria anDepartmentIdGreaterThan(Long value) {
            addCriterion("department_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("department_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Long value) {
            addCriterion("department_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Long value) {
            addCriterion("department_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Long> values) {
            addCriterion("department_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Long> values) {
            addCriterion("department_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Long value1, Long value2) {
            addCriterion("department_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Long value1, Long value2) {
            addCriterion("department_id not between", value1, value2, "id");
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

        public Criteria andDepartmentFatherIdIsNull() {
            addCriterion("department_father_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdIsNotNull() {
            addCriterion("department_father_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdEqualTo(Long value) {
            addCriterion("department_father_id =", value, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdNotEqualTo(Long value) {
            addCriterion("department_father_id <>", value, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdGreaterThan(Long value) {
            addCriterion("department_father_id >", value, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdGreaterThanOrEqualTo(Long value) {
            addCriterion("department_father_id >=", value, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdLessThan(Long value) {
            addCriterion("department_father_id <", value, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdLessThanOrEqualTo(Long value) {
            addCriterion("department_father_id <=", value, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdLike(Long value) {
            addCriterion("department_father_id like", value, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdNotLike(Long value) {
            addCriterion("department_father_id not like", value, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdIn(List<Long> values) {
            addCriterion("department_father_id in", values, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdNotIn(List<Long> values) {
            addCriterion("department_father_id not in", values, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdBetween(Long value1, Long value2) {
            addCriterion("department_father_id between", value1, value2, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentFatherIdNotBetween(Long value1, Long value2) {
            addCriterion("department_father_id not between", value1, value2, "departmentFatherId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelIsNull() {
            addCriterion("department_level is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelIsNotNull() {
            addCriterion("department_level is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelEqualTo(Integer value) {
            addCriterion("department_level =", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelNotEqualTo(Integer value) {
            addCriterion("department_level <>", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelGreaterThan(Integer value) {
            addCriterion("department_level >", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_level >=", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelLessThan(Integer value) {
            addCriterion("department_level <", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelLessThanOrEqualTo(Integer value) {
            addCriterion("department_level <=", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelLike(Integer value) {
            addCriterion("department_level like", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelNotLike(Integer value) {
            addCriterion("department_level not like", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelIn(List<Integer> values) {
            addCriterion("department_level in", values, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelNotIn(List<Integer> values) {
            addCriterion("department_level not in", values, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelBetween(Integer value1, Integer value2) {
            addCriterion("department_level between", value1, value2, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("department_level not between", value1, value2, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdIsNull() {
            addCriterion("department_leader_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdIsNotNull() {
            addCriterion("department_leader_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdEqualTo(Integer value) {
            addCriterion("department_leader_id =", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdNotEqualTo(Integer value) {
            addCriterion("department_leader_id <>", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdGreaterThan(Integer value) {
            addCriterion("department_leader_id >", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_leader_id >=", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdLessThan(Integer value) {
            addCriterion("department_leader_id <", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdLessThanOrEqualTo(Integer value) {
            addCriterion("department_leader_id <=", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdLike(Integer value) {
            addCriterion("department_leader_id like", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdNotLike(Integer value) {
            addCriterion("department_leader_id not like", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdIn(List<Integer> values) {
            addCriterion("department_leader_id in", values, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdNotIn(List<Integer> values) {
            addCriterion("department_leader_id not in", values, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdBetween(Integer value1, Integer value2) {
            addCriterion("department_leader_id between", value1, value2, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department_leader_id not between", value1, value2, "departmentLeaderId");
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table mona_department
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