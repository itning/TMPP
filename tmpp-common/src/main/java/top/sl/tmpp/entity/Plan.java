package top.sl.tmpp.entity;

public class Plan {
    private String id;

    private String year;

    private Integer term;

    private String levelId;

    private String collegeId;

    private String departmentId;

    private String courseMajor;

    private Integer courseType;

    private String useSchoolYear;

    private String clazz;

    private Integer clazzNumber;

    private String teacher;

    public Plan(String id, String year, Integer term, String levelId, String collegeId, String departmentId, String courseMajor, Integer courseType, String useSchoolYear, String clazz, Integer clazzNumber, String teacher) {
        this.id = id;
        this.year = year;
        this.term = term;
        this.levelId = levelId;
        this.collegeId = collegeId;
        this.departmentId = departmentId;
        this.courseMajor = courseMajor;
        this.courseType = courseType;
        this.useSchoolYear = useSchoolYear;
        this.clazz = clazz;
        this.clazzNumber = clazzNumber;
        this.teacher = teacher;
    }

    public Plan() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId == null ? null : levelId.trim();
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId == null ? null : collegeId.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getCourseMajor() {
        return courseMajor;
    }

    public void setCourseMajor(String courseMajor) {
        this.courseMajor = courseMajor == null ? null : courseMajor.trim();
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public String getUseSchoolYear() {
        return useSchoolYear;
    }

    public void setUseSchoolYear(String useSchoolYear) {
        this.useSchoolYear = useSchoolYear == null ? null : useSchoolYear.trim();
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    public Integer getClazzNumber() {
        return clazzNumber;
    }

    public void setClazzNumber(Integer clazzNumber) {
        this.clazzNumber = clazzNumber;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }
}