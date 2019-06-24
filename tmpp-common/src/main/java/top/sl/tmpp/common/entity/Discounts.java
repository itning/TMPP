package top.sl.tmpp.common.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Discounts {
    private String id;

    private BigDecimal discount;

    private Date gmtModified;

    private Date gmtCreate;

    public Discounts(String id, BigDecimal discount, Date gmtModified, Date gmtCreate) {
        this.id = id;
        this.discount = discount;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
    }

    public Discounts() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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