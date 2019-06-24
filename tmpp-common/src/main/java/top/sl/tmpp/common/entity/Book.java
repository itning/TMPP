package top.sl.tmpp.common.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    private String id;

    private String isbn;

    private String textBookName;

    private Boolean textBookCategory;

    private String press;

    private String author;

    private BigDecimal unitPrice;

    private Integer teacherBookNumber;

    private String discountId;

    private String awardInformation;

    private Date publicationDate;

    private String subscriber;

    private Integer subscriberTel;

    private Boolean isBookPurchase;

    private String reason;

    private String loginUserId;

    private Boolean isBuyBook;

    private String courseId;

    private Integer status;

    private Date gmtModified;

    private Date gmtCreate;

    public Book(String id, String isbn, String textBookName, Boolean textBookCategory, String press, String author, BigDecimal unitPrice, Integer teacherBookNumber, String discountId, String awardInformation, Date publicationDate, String subscriber, Integer subscriberTel, Boolean isBookPurchase, String reason, String loginUserId, Boolean isBuyBook, String courseId, Integer status, Date gmtModified, Date gmtCreate) {
        this.id = id;
        this.isbn = isbn;
        this.textBookName = textBookName;
        this.textBookCategory = textBookCategory;
        this.press = press;
        this.author = author;
        this.unitPrice = unitPrice;
        this.teacherBookNumber = teacherBookNumber;
        this.discountId = discountId;
        this.awardInformation = awardInformation;
        this.publicationDate = publicationDate;
        this.subscriber = subscriber;
        this.subscriberTel = subscriberTel;
        this.isBookPurchase = isBookPurchase;
        this.reason = reason;
        this.loginUserId = loginUserId;
        this.isBuyBook = isBuyBook;
        this.courseId = courseId;
        this.status = status;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
    }

    public Book() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getTextBookName() {
        return textBookName;
    }

    public void setTextBookName(String textBookName) {
        this.textBookName = textBookName == null ? null : textBookName.trim();
    }

    public Boolean getTextBookCategory() {
        return textBookCategory;
    }

    public void setTextBookCategory(Boolean textBookCategory) {
        this.textBookCategory = textBookCategory;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
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

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId == null ? null : discountId.trim();
    }

    public String getAwardInformation() {
        return awardInformation;
    }

    public void setAwardInformation(String awardInformation) {
        this.awardInformation = awardInformation == null ? null : awardInformation.trim();
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
        this.subscriber = subscriber == null ? null : subscriber.trim();
    }

    public Integer getSubscriberTel() {
        return subscriberTel;
    }

    public void setSubscriberTel(Integer subscriberTel) {
        this.subscriberTel = subscriberTel;
    }

    public Boolean getIsBookPurchase() {
        return isBookPurchase;
    }

    public void setIsBookPurchase(Boolean isBookPurchase) {
        this.isBookPurchase = isBookPurchase;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId == null ? null : loginUserId.trim();
    }

    public Boolean getIsBuyBook() {
        return isBuyBook;
    }

    public void setIsBuyBook(Boolean isBuyBook) {
        this.isBuyBook = isBuyBook;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
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