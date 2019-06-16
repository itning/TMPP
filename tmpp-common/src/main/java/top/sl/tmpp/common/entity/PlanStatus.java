package top.sl.tmpp.common.entity;

public class PlanStatus {
    private String id;

    private Integer status;

    public PlanStatus(String id, Integer status) {
        this.id = id;
        this.status = status;
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
}