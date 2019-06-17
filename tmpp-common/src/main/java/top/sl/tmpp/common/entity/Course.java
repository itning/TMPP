package top.sl.tmpp.common.entity;

import java.util.Date;

public class Course {
    private String id;

    private String name;

    private String code;

    private Date gmtModified;

    private Date gmtCreate;

    public Course(String id, String name, String code, Date gmtModified, Date gmtCreate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
    }

    public Course() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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
}