package top.sl.tmpp.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
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

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNull() {
            addCriterion("college_id is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNotNull() {
            addCriterion("college_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdEqualTo(String value) {
            addCriterion("college_id =", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotEqualTo(String value) {
            addCriterion("college_id <>", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThan(String value) {
            addCriterion("college_id >", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThanOrEqualTo(String value) {
            addCriterion("college_id >=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThan(String value) {
            addCriterion("college_id <", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThanOrEqualTo(String value) {
            addCriterion("college_id <=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLike(String value) {
            addCriterion("college_id like", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotLike(String value) {
            addCriterion("college_id not like", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIn(List<String> values) {
            addCriterion("college_id in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotIn(List<String> values) {
            addCriterion("college_id not in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdBetween(String value1, String value2) {
            addCriterion("college_id between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotBetween(String value1, String value2) {
            addCriterion("college_id not between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCourseMajorIsNull() {
            addCriterion("course_major is null");
            return (Criteria) this;
        }

        public Criteria andCourseMajorIsNotNull() {
            addCriterion("course_major is not null");
            return (Criteria) this;
        }

        public Criteria andCourseMajorEqualTo(String value) {
            addCriterion("course_major =", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorNotEqualTo(String value) {
            addCriterion("course_major <>", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorGreaterThan(String value) {
            addCriterion("course_major >", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorGreaterThanOrEqualTo(String value) {
            addCriterion("course_major >=", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorLessThan(String value) {
            addCriterion("course_major <", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorLessThanOrEqualTo(String value) {
            addCriterion("course_major <=", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorLike(String value) {
            addCriterion("course_major like", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorNotLike(String value) {
            addCriterion("course_major not like", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorIn(List<String> values) {
            addCriterion("course_major in", values, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorNotIn(List<String> values) {
            addCriterion("course_major not in", values, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorBetween(String value1, String value2) {
            addCriterion("course_major between", value1, value2, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorNotBetween(String value1, String value2) {
            addCriterion("course_major not between", value1, value2, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNull() {
            addCriterion("course_type is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNotNull() {
            addCriterion("course_type is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeEqualTo(Integer value) {
            addCriterion("course_type =", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotEqualTo(Integer value) {
            addCriterion("course_type <>", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThan(Integer value) {
            addCriterion("course_type >", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_type >=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThan(Integer value) {
            addCriterion("course_type <", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("course_type <=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIn(List<Integer> values) {
            addCriterion("course_type in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotIn(List<Integer> values) {
            addCriterion("course_type not in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeBetween(Integer value1, Integer value2) {
            addCriterion("course_type between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("course_type not between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearIsNull() {
            addCriterion("use_school_year is null");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearIsNotNull() {
            addCriterion("use_school_year is not null");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearEqualTo(String value) {
            addCriterion("use_school_year =", value, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearNotEqualTo(String value) {
            addCriterion("use_school_year <>", value, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearGreaterThan(String value) {
            addCriterion("use_school_year >", value, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearGreaterThanOrEqualTo(String value) {
            addCriterion("use_school_year >=", value, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearLessThan(String value) {
            addCriterion("use_school_year <", value, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearLessThanOrEqualTo(String value) {
            addCriterion("use_school_year <=", value, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearLike(String value) {
            addCriterion("use_school_year like", value, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearNotLike(String value) {
            addCriterion("use_school_year not like", value, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearIn(List<String> values) {
            addCriterion("use_school_year in", values, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearNotIn(List<String> values) {
            addCriterion("use_school_year not in", values, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearBetween(String value1, String value2) {
            addCriterion("use_school_year between", value1, value2, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andUseSchoolYearNotBetween(String value1, String value2) {
            addCriterion("use_school_year not between", value1, value2, "useSchoolYear");
            return (Criteria) this;
        }

        public Criteria andClazzIsNull() {
            addCriterion("clazz is null");
            return (Criteria) this;
        }

        public Criteria andClazzIsNotNull() {
            addCriterion("clazz is not null");
            return (Criteria) this;
        }

        public Criteria andClazzEqualTo(String value) {
            addCriterion("clazz =", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotEqualTo(String value) {
            addCriterion("clazz <>", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzGreaterThan(String value) {
            addCriterion("clazz >", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzGreaterThanOrEqualTo(String value) {
            addCriterion("clazz >=", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLessThan(String value) {
            addCriterion("clazz <", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLessThanOrEqualTo(String value) {
            addCriterion("clazz <=", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzLike(String value) {
            addCriterion("clazz like", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotLike(String value) {
            addCriterion("clazz not like", value, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzIn(List<String> values) {
            addCriterion("clazz in", values, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotIn(List<String> values) {
            addCriterion("clazz not in", values, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzBetween(String value1, String value2) {
            addCriterion("clazz between", value1, value2, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNotBetween(String value1, String value2) {
            addCriterion("clazz not between", value1, value2, "clazz");
            return (Criteria) this;
        }

        public Criteria andClazzNumberIsNull() {
            addCriterion("clazz_number is null");
            return (Criteria) this;
        }

        public Criteria andClazzNumberIsNotNull() {
            addCriterion("clazz_number is not null");
            return (Criteria) this;
        }

        public Criteria andClazzNumberEqualTo(Integer value) {
            addCriterion("clazz_number =", value, "clazzNumber");
            return (Criteria) this;
        }

        public Criteria andClazzNumberNotEqualTo(Integer value) {
            addCriterion("clazz_number <>", value, "clazzNumber");
            return (Criteria) this;
        }

        public Criteria andClazzNumberGreaterThan(Integer value) {
            addCriterion("clazz_number >", value, "clazzNumber");
            return (Criteria) this;
        }

        public Criteria andClazzNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("clazz_number >=", value, "clazzNumber");
            return (Criteria) this;
        }

        public Criteria andClazzNumberLessThan(Integer value) {
            addCriterion("clazz_number <", value, "clazzNumber");
            return (Criteria) this;
        }

        public Criteria andClazzNumberLessThanOrEqualTo(Integer value) {
            addCriterion("clazz_number <=", value, "clazzNumber");
            return (Criteria) this;
        }

        public Criteria andClazzNumberIn(List<Integer> values) {
            addCriterion("clazz_number in", values, "clazzNumber");
            return (Criteria) this;
        }

        public Criteria andClazzNumberNotIn(List<Integer> values) {
            addCriterion("clazz_number not in", values, "clazzNumber");
            return (Criteria) this;
        }

        public Criteria andClazzNumberBetween(Integer value1, Integer value2) {
            addCriterion("clazz_number between", value1, value2, "clazzNumber");
            return (Criteria) this;
        }

        public Criteria andClazzNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("clazz_number not between", value1, value2, "clazzNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNull() {
            addCriterion("teacher is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNotNull() {
            addCriterion("teacher is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEqualTo(String value) {
            addCriterion("teacher =", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotEqualTo(String value) {
            addCriterion("teacher <>", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThan(String value) {
            addCriterion("teacher >", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("teacher >=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThan(String value) {
            addCriterion("teacher <", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThanOrEqualTo(String value) {
            addCriterion("teacher <=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLike(String value) {
            addCriterion("teacher like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotLike(String value) {
            addCriterion("teacher not like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherIn(List<String> values) {
            addCriterion("teacher in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotIn(List<String> values) {
            addCriterion("teacher not in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherBetween(String value1, String value2) {
            addCriterion("teacher between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotBetween(String value1, String value2) {
            addCriterion("teacher not between", value1, value2, "teacher");
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

        public Criteria andExecutePlanIdIsNull() {
            addCriterion("execute_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdIsNotNull() {
            addCriterion("execute_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdEqualTo(String value) {
            addCriterion("execute_plan_id =", value, "executePlanId");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdNotEqualTo(String value) {
            addCriterion("execute_plan_id <>", value, "executePlanId");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdGreaterThan(String value) {
            addCriterion("execute_plan_id >", value, "executePlanId");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdGreaterThanOrEqualTo(String value) {
            addCriterion("execute_plan_id >=", value, "executePlanId");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdLessThan(String value) {
            addCriterion("execute_plan_id <", value, "executePlanId");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdLessThanOrEqualTo(String value) {
            addCriterion("execute_plan_id <=", value, "executePlanId");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdLike(String value) {
            addCriterion("execute_plan_id like", value, "executePlanId");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdNotLike(String value) {
            addCriterion("execute_plan_id not like", value, "executePlanId");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdIn(List<String> values) {
            addCriterion("execute_plan_id in", values, "executePlanId");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdNotIn(List<String> values) {
            addCriterion("execute_plan_id not in", values, "executePlanId");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdBetween(String value1, String value2) {
            addCriterion("execute_plan_id between", value1, value2, "executePlanId");
            return (Criteria) this;
        }

        public Criteria andExecutePlanIdNotBetween(String value1, String value2) {
            addCriterion("execute_plan_id not between", value1, value2, "executePlanId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}