package top.sl.tmpp.common.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 办公室主任我的审核
 *
 * @author itning
 * @date 2019/6/23 11:40
 */
public class OReview {
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

    private Date gmtModified;

    private Date gmtCreate;

    private String planId;

    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        this.reason = reason;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
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
        this.loginUserId = loginUserId;
    }

    public String getIsBuyBook() {
        return isBuyBook;
    }

    public void setIsBuyBook(String isBuyBook) {
        this.isBuyBook = isBuyBook;
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

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OReview{" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                ", textBookName='" + textBookName + '\'' +
                ", textBookCategory=" + textBookCategory +
                ", press=" + press +
                ", author='" + author + '\'' +
                ", unitPrice=" + unitPrice +
                ", teacherBookNumber=" + teacherBookNumber +
                ", awardInformation='" + awardInformation + '\'' +
                ", publicationDate=" + publicationDate +
                ", subscriber='" + subscriber + '\'' +
                ", subscriberTel=" + subscriberTel +
                ", isBookPurchase=" + isBookPurchase +
                ", reason='" + reason + '\'' +
                ", courseId='" + courseId + '\'' +
                ", discountId='" + discountId + '\'' +
                ", affairsNumber=" + affairsNumber +
                ", loginUserId='" + loginUserId + '\'' +
                ", isBuyBook='" + isBuyBook + '\'' +
                ", gmtModified=" + gmtModified +
                ", gmtCreate=" + gmtCreate +
                ", planId='" + planId + '\'' +
                ", status=" + status +
                '}';
    }
}
