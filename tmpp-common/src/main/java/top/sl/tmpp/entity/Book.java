package top.sl.tmpp.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    private String id;

    private String isbn;

    private String textBookName;

    private Integer textBookCategory;

    private Integer press;

    private String author;

    private BigDecimal unitPrice;

    private Integer teacherBookNumber;

    private String awardInformation;

    private Date publicationDate;

    private String subscriber;

    private Integer subscriberTel;

    private Integer isBookPurchase;

    private String reason;

    private String courseId;

    private String discountId;

    private Integer affairsNumber;

    private String loginUserId;

    private String isBuyBook;

    public Book(String id, String isbn, String textBookName, Integer textBookCategory, Integer press, String author, BigDecimal unitPrice, Integer teacherBookNumber, String awardInformation, Date publicationDate, String subscriber, Integer subscriberTel, Integer isBookPurchase, String reason, String courseId, String discountId, Integer affairsNumber, String loginUserId, String isBuyBook) {
        this.id = id;
        this.isbn = isbn;
        this.textBookName = textBookName;
        this.textBookCategory = textBookCategory;
        this.press = press;
        this.author = author;
        this.unitPrice = unitPrice;
        this.teacherBookNumber = teacherBookNumber;
        this.awardInformation = awardInformation;
        this.publicationDate = publicationDate;
        this.subscriber = subscriber;
        this.subscriberTel = subscriberTel;
        this.isBookPurchase = isBookPurchase;
        this.reason = reason;
        this.courseId = courseId;
        this.discountId = discountId;
        this.affairsNumber = affairsNumber;
        this.loginUserId = loginUserId;
        this.isBuyBook = isBuyBook;
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

    public Integer getTextBookCategory() {
        return textBookCategory;
    }

    public void setTextBookCategory(Integer textBookCategory) {
        this.textBookCategory = textBookCategory;
    }

    public Integer getPress() {
        return press;
    }

    public void setPress(Integer press) {
        this.press = press;
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

    public Integer getIsBookPurchase() {
        return isBookPurchase;
    }

    public void setIsBookPurchase(Integer isBookPurchase) {
        this.isBookPurchase = isBookPurchase;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId == null ? null : discountId.trim();
    }

    public Integer getAffairsNumber() {
        return affairsNumber;
    }

    public void setAffairsNumber(Integer affairsNumber) {
        this.affairsNumber = affairsNumber;
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId == null ? null : loginUserId.trim();
    }

    public String getIsBuyBook() {
        return isBuyBook;
    }

    public void setIsBuyBook(String isBuyBook) {
        this.isBuyBook = isBuyBook == null ? null : isBuyBook.trim();
    }
}