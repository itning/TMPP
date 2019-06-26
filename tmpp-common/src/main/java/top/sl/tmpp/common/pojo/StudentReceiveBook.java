package top.sl.tmpp.common.pojo;

import java.math.BigDecimal;

/**
 * 班级领取教材反馈表
 *
 * @author ShuLu
 * @date 2019/6/26 11:38
 */
public class StudentReceiveBook {
    /**
     * 开课院系
     */
    private String collegesName;
    /**
     * 使用班级
     */
    private String clazz;
    /**
     * 书籍编号
     */
    private String isbn;
    /**
     * 教材名称
     */
    private String textBookName;
    /**
     * 出版社
     */
    private String press;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 数量
     */
    private Integer clazzNumber;
    /**
     * 折扣
     */
    private BigDecimal discounts;

    public StudentReceiveBook() {
    }

    public StudentReceiveBook(String collegesName, String clazz, String isbn, String textBookName, String press, BigDecimal unitPrice, Integer clazzNumber, BigDecimal discounts) {
        this.collegesName = collegesName;
        this.clazz = clazz;
        this.isbn = isbn;
        this.textBookName = textBookName;
        this.press = press;
        this.unitPrice = unitPrice;
        this.clazzNumber = clazzNumber;
        this.discounts = discounts;
    }

    public String getCollegesName() {
        return collegesName;
    }

    public void setCollegesName(String collegesName) {
        this.collegesName = collegesName;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTextBookName() {
        return textBookName;
    }

    public void setTextBookName(String textBookName) {
        this.textBookName = textBookName;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getClazzNumber() {
        return clazzNumber;
    }

    public void setClazzNumber(Integer clazzNumber) {
        this.clazzNumber = clazzNumber;
    }

    public BigDecimal getDiscounts() {
        return discounts;
    }

    public void setDiscounts(BigDecimal discounts) {
        this.discounts = discounts;
    }
}
