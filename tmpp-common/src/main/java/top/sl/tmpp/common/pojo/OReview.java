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

    private Boolean textBookCategory;

    private String press;

    private String author;

    private BigDecimal unitPrice;

    private Integer teacherBookNumber;

    private String discountId;

    private String awardInformation;

    private Date publicationDate;

    private String subscriber;

    private String subscriberTel;

    private Boolean isBookPurchase;

    private String reason;

    private String loginUserId;

    private String courseId;

    private Integer status;

    private Date gmtModified;

    private Date gmtCreate;

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

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
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

    public Boolean getBookPurchase() {
        return isBookPurchase;
    }

    public void setBookPurchase(Boolean bookPurchase) {
        isBookPurchase = bookPurchase;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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

    @Override
    public String toString() {
        return "OReview{" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                ", textBookName='" + textBookName + '\'' +
                ", textBookCategory=" + textBookCategory +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", unitPrice=" + unitPrice +
                ", teacherBookNumber=" + teacherBookNumber +
                ", discountId='" + discountId + '\'' +
                ", awardInformation='" + awardInformation + '\'' +
                ", publicationDate=" + publicationDate +
                ", subscriber='" + subscriber + '\'' +
                ", subscriberTel='" + subscriberTel + '\'' +
                ", isBookPurchase=" + isBookPurchase +
                ", reason='" + reason + '\'' +
                ", loginUserId='" + loginUserId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", status=" + status +
                ", gmtModified=" + gmtModified +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}
