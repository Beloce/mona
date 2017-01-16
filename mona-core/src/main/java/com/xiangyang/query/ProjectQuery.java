package com.xiangyang.query;


import com.xiangyang.util.query.support.BaseQuery;
import com.xiangyang.util.query.support.BaseCriteria;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    public ProjectQuery() {
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
     * This class corresponds to the database table mona_project
     */
         protected abstract static class GeneratedCriteria extends BaseCriteria {

        protected GeneratedCriteria() {
            super();
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria anProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("project_id not between", value1, value2, "id");
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

        public Criteria andFatherProjectIdIsNull() {
            addCriterion("father_project_id is null");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdIsNotNull() {
            addCriterion("father_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdEqualTo(String value) {
            addCriterion("father_project_id =", value, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdNotEqualTo(String value) {
            addCriterion("father_project_id <>", value, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdGreaterThan(String value) {
            addCriterion("father_project_id >", value, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("father_project_id >=", value, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdLessThan(String value) {
            addCriterion("father_project_id <", value, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdLessThanOrEqualTo(String value) {
            addCriterion("father_project_id <=", value, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdLike(String value) {
            addCriterion("father_project_id like", value, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdNotLike(String value) {
            addCriterion("father_project_id not like", value, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdIn(List<String> values) {
            addCriterion("father_project_id in", values, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdNotIn(List<String> values) {
            addCriterion("father_project_id not in", values, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdBetween(String value1, String value2) {
            addCriterion("father_project_id between", value1, value2, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andFatherProjectIdNotBetween(String value1, String value2) {
            addCriterion("father_project_id not between", value1, value2, "fatherProjectId");
            return (Criteria) this;
        }

        public Criteria andProjectLevelIsNull() {
            addCriterion("project_level is null");
            return (Criteria) this;
        }

        public Criteria andProjectLevelIsNotNull() {
            addCriterion("project_level is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLevelEqualTo(Integer value) {
            addCriterion("project_level =", value, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectLevelNotEqualTo(Integer value) {
            addCriterion("project_level <>", value, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectLevelGreaterThan(Integer value) {
            addCriterion("project_level >", value, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_level >=", value, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectLevelLessThan(Integer value) {
            addCriterion("project_level <", value, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectLevelLessThanOrEqualTo(Integer value) {
            addCriterion("project_level <=", value, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectLevelLike(Integer value) {
            addCriterion("project_level like", value, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectLevelNotLike(Integer value) {
            addCriterion("project_level not like", value, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectLevelIn(List<Integer> values) {
            addCriterion("project_level in", values, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectLevelNotIn(List<Integer> values) {
            addCriterion("project_level not in", values, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectLevelBetween(Integer value1, Integer value2) {
            addCriterion("project_level between", value1, value2, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("project_level not between", value1, value2, "projectLevel");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdIsNull() {
            addCriterion("leader_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdIsNotNull() {
            addCriterion("leader_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdEqualTo(Long value) {
            addCriterion("leader_user_id =", value, "leaderUserId");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdNotEqualTo(Long value) {
            addCriterion("leader_user_id <>", value, "leaderUserId");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdGreaterThan(Long value) {
            addCriterion("leader_user_id >", value, "leaderUserId");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("leader_user_id >=", value, "leaderUserId");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdLessThan(Long value) {
            addCriterion("leader_user_id <", value, "leaderUserId");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdLessThanOrEqualTo(Long value) {
            addCriterion("leader_user_id <=", value, "leaderUserId");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdLike(Long value) {
            addCriterion("leader_user_id like", value, "leaderUserId");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdNotLike(Long value) {
            addCriterion("leader_user_id not like", value, "leaderUserId");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdIn(List<Long> values) {
            addCriterion("leader_user_id in", values, "leaderUserId");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdNotIn(List<Long> values) {
            addCriterion("leader_user_id not in", values, "leaderUserId");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdBetween(Long value1, Long value2) {
            addCriterion("leader_user_id between", value1, value2, "leaderUserId");
            return (Criteria) this;
        }

        public Criteria andLeaderUserIdNotBetween(Long value1, Long value2) {
            addCriterion("leader_user_id not between", value1, value2, "leaderUserId");
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table mona_project
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