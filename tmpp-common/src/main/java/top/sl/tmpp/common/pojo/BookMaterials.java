package top.sl.tmpp.common.pojo;

/**
 * 征订教材汇总表格
 *
 * @author ShuLu
 * @date 2019/6/26 10:53
 */
public class BookMaterials {
    /**
     * 授课部门名称
     */
    private String departmentName;
    /**
     * 开课院系
     */
    private String collegesName;
    /**
     * 专业
     */
    private String startPro;
    /**
     * 课程号
     */
    private String courseCode;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 教材名称
     */
    private String textBookName;
    /**
     * 书籍编号
     */
    private String isbn;
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
    private String unitPrice;
    /**
     * 获奖信息
     */
    private String awardInformation;
    /**
     * 出版日期
     */
    private String publicationDate;
    /**
     * 使用年级
     */
    private String grade;
    /**
     * 使用班级
     */
    private String clazz;
    /**
     * 使用班级人数
     */
    private String clazzNumber;
    /**
     * 教师样书数量
     */
    private String teacherBookNumber;
    /**
     * 教务处是否购书
     */
    private Integer isBuyBook;
    /**
     * 征订人
     */
    private String subscriber;
    /**
     * 征订人电话
     */
    private String subscriberTel;
    /**
     * 状态
     */
    private String status;
    /**
     * 是否购书
     */
    private String isBookPurchase;
    /**
     * 未购书必须有原因，购书可不写原因
     */
    private String reason;
    /**
     * 备注
     */
    private String remark;

    public BookMaterials() {
    }

    public BookMaterials(String departmentName, String collegesName, String startPro, String courseCode, String courseName, String textBookName, String isbn, String textBookCategory, String press, String author, String unitPrice, String awardInformation, String publicationDate, String grade, String clazz, String clazzNumber, String teacherBookNumber, Integer isBuyBook, String subscriber, String subscriberTel, String status, String isBookPurchase, String reason, String remark) {
        this.departmentName = departmentName;
        this.collegesName = collegesName;
        this.startPro = startPro;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.textBookName = textBookName;
        this.isbn = isbn;
        this.textBookCategory = textBookCategory;
        this.press = press;
        this.author = author;
        this.unitPrice = unitPrice;
        this.awardInformation = awardInformation;
        this.publicationDate = publicationDate;
        this.grade = grade;
        this.clazz = clazz;
        this.clazzNumber = clazzNumber;
        this.teacherBookNumber = teacherBookNumber;
        this.isBuyBook = isBuyBook;
        this.subscriber = subscriber;
        this.subscriberTel = subscriberTel;
        this.status = status;
        this.isBookPurchase = isBookPurchase;
        this.reason = reason;
        this.remark = remark;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCollegesName() {
        return collegesName;
    }

    public void setCollegesName(String collegesName) {
        this.collegesName = collegesName;
    }

    public String getStartPro() {
        return startPro;
    }

    public void setStartPro(String startPro) {
        this.startPro = startPro;
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

    public String getTextBookName() {
        return textBookName;
    }

    public void setTextBookName(String textBookName) {
        this.textBookName = textBookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getAwardInformation() {
        return awardInformation;
    }

    public void setAwardInformation(String awardInformation) {
        this.awardInformation = awardInformation;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
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

    public String getClazzNumber() {
        return clazzNumber;
    }

    public void setClazzNumber(String clazzNumber) {
        this.clazzNumber = clazzNumber;
    }

    public String getTeacherBookNumber() {
        return teacherBookNumber;
    }

    public void setTeacherBookNumber(String teacherBookNumber) {
        this.teacherBookNumber = teacherBookNumber;
    }

    public Integer isBuyBook() {
        return isBuyBook;
    }

    public void setBuyBook(Integer buyBook) {
        isBuyBook = buyBook;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
