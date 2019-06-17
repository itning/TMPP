package top.sl.tmpp.common.entity;

import java.util.Date;

public class PlanStatus {
    private String id;

    private Integer status;

    private Date gmtModified;

    private Date gmtCreate;

    public PlanStatus(String id, Integer status, Date gmtModified, Date gmtCreate) {
        this.id = id;
        this.status = status;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
    }

    public PlanStatus() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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