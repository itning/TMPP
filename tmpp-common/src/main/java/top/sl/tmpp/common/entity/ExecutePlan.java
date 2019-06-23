package top.sl.tmpp.common.entity;

import java.util.Date;

public class ExecutePlan {
    private String id;

    private String year;

    private Integer term;

    private String levelId;

    private Date gmtModified;

    private Date gmtCreate;

    private String departmentId;

    private String fileType;

    private byte[] file;

    public ExecutePlan(String id, String year, Integer term, String levelId, Date gmtModified, Date gmtCreate, String departmentId, String fileType) {
        this.id = id;
        this.year = year;
        this.term = term;
        this.levelId = levelId;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
        this.departmentId = departmentId;
        this.fileType = fileType;
    }

    public ExecutePlan(String id, String year, Integer term, String levelId, Date gmtModified, Date gmtCreate, String departmentId, String fileType, byte[] file) {
        this.id = id;
        this.year = year;
        this.term = term;
        this.levelId = levelId;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
        this.departmentId = departmentId;
        this.fileType = fileType;
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

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId == null ? null : levelId.trim();
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}