package top.sl.tmpp.common.entity;

import java.util.Date;

public class Plan {
    private String id;

    private String collegeId;

    private String courseMajor;

    private Integer courseType;

    private String useSchoolYear;

    private String clazz;

    private Integer clazzNumber;

    private String teacher;

    private Date gmtModified;

    private Date gmtCreate;

    private String executePlanId;

    public Plan(String id, String collegeId, String courseMajor, Integer courseType, String useSchoolYear, String clazz, Integer clazzNumber, String teacher, Date gmtModified, Date gmtCreate, String executePlanId) {
        this.id = id;
        this.collegeId = collegeId;
        this.courseMajor = courseMajor;
        this.courseType = courseType;
        this.useSchoolYear = useSchoolYear;
        this.clazz = clazz;
        this.clazzNumber = clazzNumber;
        this.teacher = teacher;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
        this.executePlanId = executePlanId;
    }

    public Plan() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId == null ? null : collegeId.trim();
    }

    public String getCourseMajor() {
        return courseMajor;
    }

    public void setCourseMajor(String courseMajor) {
        this.courseMajor = courseMajor == null ? null : courseMajor.trim();
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public String getUseSchoolYear() {
        return useSchoolYear;
    }

    public void setUseSchoolYear(String useSchoolYear) {
        this.useSchoolYear = useSchoolYear == null ? null : useSchoolYear.trim();
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    public Integer getClazzNumber() {
        return clazzNumber;
    }

    public void setClazzNumber(Integer clazzNumber) {
        this.clazzNumber = clazzNumber;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getExecutePlanId() {
        return executePlanId;
    }

    public void setExecutePlanId(String executePlanId) {
        this.executePlanId = executePlanId == null ? null : executePlanId.trim();
    }
}