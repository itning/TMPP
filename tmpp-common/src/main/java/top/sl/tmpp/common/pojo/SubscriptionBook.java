package top.sl.tmpp.common.pojo;

import java.math.BigDecimal;

/**
 * 征订教材样书统计表
 *
 * @author ShuLu
 * @date 2019/6/26 11:22
 */
public class SubscriptionBook {
    /**
     * 授课部门名称
     */
    private String departmentName;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程类型
     */
    private String type;
    /**
     * 专业
     */
    private String startPro;
    /**
     * 教材名称
     */
    private String textBookName;
    /**
     * 作者
     */
    private String author;
    /**
     * 出版社
     */
    private String press;
    /**
     * 书籍编号
     */
    private String isbn;
    /**
     * 出版日期
     */
    private String publicationDate;
    /**
     * 获奖信息
     */
    private String awardInformation;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 使用年级
     */
    private String grade;
    /**
     * 教务处样书
     */
    private Byte is_buy_book;
    /**
     * 征订人
     */
    private String subscriber;
    /**
     * 征订人电话
     */
    private String subscriberTel;
    /**
     * 备注
     */
    private String remark;

    public SubscriptionBook() {
    }

    public SubscriptionBook(String departmentName, String courseName, String type, String startPro, String textBookName, String author, String press, String isbn, String publicationDate, String awardInformation, BigDecimal unitPrice, String grade, Byte is_buy_book, String subscriber, String subscriberTel, String remark) {
        this.departmentName = departmentName;
        this.courseName = courseName;
        this.type = type;
        this.startPro = startPro;
        this.textBookName = textBookName;
        this.author = author;
        this.press = press;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.awardInformation = awardInformation;
        this.unitPrice = unitPrice;
        this.grade = grade;
        this.is_buy_book = is_buy_book;
        this.subscriber = subscriber;
        this.subscriberTel = subscriberTel;
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStartPro() {
        return startPro;
    }

    public void setStartPro(String startPro) {
        this.startPro = startPro;
    }

    public String getTextBookName() {
        return textBookName;
    }

    public void setTextBookName(String textBookName) {
        this.textBookName = textBookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAwardInformation() {
        return awardInformation;
    }

    public void setAwardInformation(String awardInformation) {
        this.awardInformation = awardInformation;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getSubscriberTel() {
        return subscriberTel;
    }

    public void setSubscriberTel(String subscriberTel) {
        this.subscriberTel = subscriberTel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getIs_buy_book() {
        return is_buy_book;
    }

    public void setIs_buy_book(Byte is_buy_book) {
        this.is_buy_book = is_buy_book;
    }
}
