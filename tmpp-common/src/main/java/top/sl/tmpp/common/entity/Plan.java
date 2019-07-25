package top.sl.tmpp.common.entity;

import java.util.Date;

public class Plan {
    private String id;

    private String collegesId;

    private String courseCode;

    private String courseName;

    private String startPro;

    private Boolean type;

    private String clazz;

    private Integer clazzNumber;

    private String teacher;

    private String remark;

    private String executePlanId;

    private Date gmtCreate;

    private Date gmtModified;

    public Plan(String id, String collegesId, String courseCode, String courseName, String startPro, Boolean type, String clazz, Integer clazzNumber, String teacher, String remark, String executePlanId, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.collegesId = collegesId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.startPro = startPro;
        this.type = type;
        this.clazz = clazz;
        this.clazzNumber = clazzNumber;
        this.teacher = teacher;
        this.remark = remark;
        this.executePlanId = executePlanId;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
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

    public String getCollegesId() {
        return collegesId;
    }

    public void setCollegesId(String collegesId) {
        this.collegesId = collegesId == null ? null : collegesId.trim();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getStartPro() {
        return startPro;
    }

    public void setStartPro(String startPro) {
        this.startPro = startPro == null ? null : startPro.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getExecutePlanId() {
        return executePlanId;
    }

    public void setExecutePlanId(String executePlanId) {
        this.executePlanId = executePlanId == null ? null : executePlanId.trim();
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
}