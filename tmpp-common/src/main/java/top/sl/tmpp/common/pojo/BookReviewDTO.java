package top.sl.tmpp.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 教务处我的审核
 *
 * @author itning
 */
public class BookReviewDTO {
    private String id;

    private String courseCode;

    private String courseName;

    private String isbn;

    private String textBookName;

    private Boolean textBookCategory;

    private String press;

    private String author;

    private BigDecimal unitPrice;

    private Integer teacherBookNumber;

    private BigDecimal discount;

    private String awardInformation;
    @DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date publicationDate;

    private String subscriber;

    private String subscriberTel;

    private Boolean isBookPurchase;

    private String reason;

    private String loginUserId;

    private Boolean isBuyBook;

    private Integer status;

    private Date gmtModified;

    private Date gmtCreate;

    public BookReviewDTO(String id, String courseCode, String courseName, String isbn, String textBookName, Boolean textBookCategory, String press, String author, BigDecimal unitPrice, Integer teacherBookNumber, BigDecimal discount, String awardInformation, Date publicationDate, String subscriber, String subscriberTel, Boolean isBookPurchase, String reason, String loginUserId, Boolean isBuyBook, Integer status, Date gmtModified, Date gmtCreate) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
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
        this.loginUserId = loginUserId;
        this.isBuyBook = isBuyBook;
        this.status = status;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
    }

    public BookReviewDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public Boolean getBuyBook() {
        return isBuyBook;
    }

    public void setBuyBook(Boolean buyBook) {
        isBuyBook = buyBook;
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
        return "BookReviewDTO{" +
                "id='" + id + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", textBookName='" + textBookName + '\'' +
                ", textBookCategory=" + textBookCategory +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", unitPrice=" + unitPrice +
                ", teacherBookNumber=" + teacherBookNumber +
                ", discount=" + discount +
                ", awardInformation='" + awardInformation + '\'' +
                ", publicationDate=" + publicationDate +
                ", subscriber='" + subscriber + '\'' +
                ", subscriberTel='" + subscriberTel + '\'' +
                ", isBookPurchase=" + isBookPurchase +
                ", reason='" + reason + '\'' +
                ", loginUserId='" + loginUserId + '\'' +
                ", isBuyBook=" + isBuyBook +
                ", status=" + status +
                ", gmtModified=" + gmtModified +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}