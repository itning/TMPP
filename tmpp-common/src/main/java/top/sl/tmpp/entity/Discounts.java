package top.sl.tmpp.entity;

import java.math.BigDecimal;

public class Discounts {
    private String id;

    private BigDecimal discount;

    public Discounts(String id, BigDecimal discount) {
        this.id = id;
        this.discount = discount;
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
}