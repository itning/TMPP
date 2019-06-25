package top.sl.tmpp.common.entity;

import java.util.Date;

public class ExecutePlan {
    private String id;

    private String year;

    private Boolean term;

    private Integer grade;

    private Boolean status;

    private String fileType;

    private String levelId;

    private String departmentId;

    private Date gmtModified;

    private Date gmtCreate;

    private byte[] file;

    public ExecutePlan(String fileType, byte[] file) {
        this.fileType = fileType;
        this.file = file;
    }

    public ExecutePlan(String id, String year, Boolean term, Integer grade, Boolean status, String fileType, String levelId, String departmentId, Date gmtModified, Date gmtCreate) {
        this.id = id;
        this.year = year;
        this.term = term;
        this.grade = grade;
        this.status = status;
        this.fileType = fileType;
        this.levelId = levelId;
        this.departmentId = departmentId;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
    }

    public ExecutePlan(String id, String year, Boolean term, Integer grade, Boolean status, String fileType, String levelId, String departmentId, Date gmtModified, Date gmtCreate, byte[] file) {
        this.id = id;
        this.year = year;
        this.term = term;
        this.grade = grade;
        this.status = status;
        this.fileType = fileType;
        this.levelId = levelId;
        this.departmentId = departmentId;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
        this.file = file;
    }

    public ExecutePlan() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Boolean getTerm() {
        return term;
    }

    public void setTerm(Boolean term) {
        this.term = term;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId == null ? null : levelId.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}