package top.sl.tmpp.common.entity;

import java.util.Date;

public class LoginUser {
    private String id;

    private String name;

    private String userType;

    private Date gmtCreate;

    private Date gmtModified;

    public LoginUser(String id, String name, String userType, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.name = name;
        this.userType = userType;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public LoginUser() {
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
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

    @Override
    public String toString() {
        return "LoginUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userType='" + userType + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}