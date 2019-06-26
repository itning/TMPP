package top.sl.tmpp.common.pojo;

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
    private String unitPprice;
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
    private String teacherBookNumber;
    /**
     * 征订人
     */
    private String subscriber;

    public TeacherReceiveBook() {
    }

    public TeacherReceiveBook(String departmentName, String courseName, String type, String startPro, String textBookName, String author, String press, String isbn, String publicationDate, String awardInformation, String unitPprice, String grade, String clazz, String teacherBookNumber, String subscriber) {
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
        this.unitPprice = unitPprice;
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

    public String getUnitPprice() {
        return unitPprice;
    }

    public void setUnitPprice(String unitPprice) {
        this.unitPprice = unitPprice;
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

    public String getTeacherBookNumber() {
        return teacherBookNumber;
    }

    public void setTeacherBookNumber(String teacherBookNumber) {
        this.teacherBookNumber = teacherBookNumber;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }
}
