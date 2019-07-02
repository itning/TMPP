package top.sl.tmpp.common.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 征订教材计划统计表
 *
 * @author ShuLu
 * @date 2019/6/29 12:22
 */
public class SubscriptionBookPlan {
    /**
     * 课程代码
     */
    private String code;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 书籍编号
     */
    private String isbn;
    /**
     * 教材名称
     */
    private String textBookName;
    /**
     * 教材类别
     */
    private String textBookCategory;
    /**
     * 出版社
     */
    private String press;
    /**
     * 作者
     */
    private String author;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 教师样书数量
     */
    private Integer teacherBookNumber;
    /**
     * 折扣
     */
    private BigDecimal discount;
    /**
     * 获奖信息
     */
    private String awardInformation;
    /**
     * 出版日期
     */
    private Date publicationDate;
    /**
     * 征订人
     */
    private String subscriber;
    /**
     * 联系电话
     */
    private String subscriberTel;
    /**
     * 是否购书
     */
    private String isBookPurchase;
    /**
     * 备注
     */
    private String reason;

    public SubscriptionBookPlan() {
    }

    public SubscriptionBookPlan(String code, String name, String isbn, String textBookName, String textBookCategory, String press, String author, BigDecimal unitPrice, Integer teacherBookNumber, BigDecimal discount, String awardInformation, Date publicationDate, String subscriber, String subscriberTel, String isBookPurchase, String reason) {
        this.code = code;
        this.name = name;
        this.isbn = isbn;
        this.textBookName = textBookName;
        this.textBookCategory = textBookCategory;
        this.press = press;
        this.author = author;
        this.unitPrice = unitPrice;
        this.teacherBookNumber = teacherBookNumber;
        this.discount = discount;
        this.awardInformation = awardInformation;
        this.publicationDate = publicationDate;
        this.subscriber = subscriber;
        this.subscriberTel = subscriberTel;
        this.isBookPurchase = isBookPurchase;
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTextBookCategory() {
        return textBookCategory;
    }

    public void setTextBookCategory(String textBookCategory) {
        this.textBookCategory = textBookCategory;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getTeacherBookNumber() {
        return teacherBookNumber;
    }

    public void setTeacherBookNumber(Integer teacherBookNumber) {
        this.teacherBookNumber = teacherBookNumber;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getAwardInformation() {
        return awardInformation;
    }

    public void setAwardInformation(String awardInformation) {
        this.awardInformation = awardInformation;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
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

    public String getIsBookPurchase() {
        return isBookPurchase;
    }

    public void setIsBookPurchase(String isBookPurchase) {
        this.isBookPurchase = isBookPurchase;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
