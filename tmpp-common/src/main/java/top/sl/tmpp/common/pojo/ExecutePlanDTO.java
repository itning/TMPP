package top.sl.tmpp.common.pojo;

import java.util.Date;

/**
 * @author itning
 * @date 2019/6/29 19:46
 */
public class ExecutePlanDTO {
    private String id;

    private String year;

    private Boolean term;

    private Integer grade;

    private Boolean status;

    private String level;

    private String department;

    private Date gmtModified;

    private Date gmtCreate;

    public ExecutePlanDTO() {
    }

    public ExecutePlanDTO(String id, String year, Boolean term, Integer grade, Boolean status, String level, String department, Date gmtModified, Date gmtCreate) {
        this.id = id;
        this.year = year;
        this.term = term;
        this.grade = grade;
        this.status = status;
        this.level = level;
        this.department = department;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    @Override
    public String toString() {
        return "ExecutePlanDTO{" +
                "id='" + id + '\'' +
                ", year='" + year + '\'' +
                ", term=" + term +
                ", grade=" + grade +
                ", status=" + status +
                ", level='" + level + '\'' +
                ", department='" + department + '\'' +
                ", gmtModified=" + gmtModified +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}
