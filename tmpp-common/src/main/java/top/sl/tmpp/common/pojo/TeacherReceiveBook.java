package top.sl.tmpp.common.pojo;

import java.math.BigDecimal;

/**
 * 教师领取教材汇总表
 *
 * @author ShuLu
 * @date 2019/6/26 11:31
 */
public class TeacherReceiveBook {
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
     * 书号isbn
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
     * 使用班级
     */
    private String clazz;
    /**
     * 教师样书数量
     */
    private Integer teacherBookNumber;
    /**
     * 征订人
     */
    private String subscriber;

    public TeacherReceiveBook() {
    }

    public TeacherReceiveBook(String departmentName, String courseName, String type, String startPro, String textBookName, String author, String press, String isbn, String publicationDate, String awardInformation, BigDecimal unitPrice, String grade, String clazz, Integer teacherBookNumber, String subscriber) {
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
        this.clazz = clazz;
        this.teacherBookNumber = teacherBookNumber;
        this.subscriber = subscriber;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Integer getTeacherBookNumber() {
        return teacherBookNumber;
    }

    public void setTeacherBookNumber(Integer teacherBookNumber) {
        this.teacherBookNumber = teacherBookNumber;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }
}
