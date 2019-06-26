package top.sl.tmpp.common.pojo;

import java.math.BigDecimal;

/**
 * 采购教材汇总表
 *
 * @author ShuLu
 * @date 2019/6/26 11:44
 */
public class PurchasingMaterials {
    /**
     * 教材名称
     */
    private String textBookName;
    /**
     * 出版社
     */
    private String press;
    /**
     * 作者
     */
    private String author;
    /**
     * 书籍编号
     */
    private String isbn;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 使用班级人数
     */
    private Integer clazzNumber;
    /**
     * 教师样书数量
     */
    private Integer teacherBookNumber;
    /**
     * 教务处是否购书
     */
    private Boolean isBuyBook;
    /**
     * 购书总数
     */
    private Integer total;

    public PurchasingMaterials() {
    }

    public PurchasingMaterials(String textBookName, String press, String author, String isbn, BigDecimal unitPrice, Integer clazzNumber, Integer teacherBookNumber, Boolean isBuyBook, Integer total) {
        this.textBookName = textBookName;
        this.press = press;
        this.author = author;
        this.isbn = isbn;
        this.unitPrice = unitPrice;
        this.clazzNumber = clazzNumber;
        this.teacherBookNumber = teacherBookNumber;
        this.isBuyBook = isBuyBook;
        this.total = total;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public Integer getTeacherBookNumber() {
        return teacherBookNumber;
    }

    public void setTeacherBookNumber(Integer teacherBookNumber) {
        this.teacherBookNumber = teacherBookNumber;
    }

    public Boolean getBuyBook() {
        return isBuyBook;
    }

    public void setBuyBook(Boolean buyBook) {
        isBuyBook = buyBook;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
