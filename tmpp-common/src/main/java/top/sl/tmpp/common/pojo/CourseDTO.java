package top.sl.tmpp.common.pojo;

/**
 * 课程信息DTO
 *
 * @author itning
 * @date 2019/7/1 15:24
 */
public class CourseDTO {
    private String courseCode;
    private String courseName;

    public CourseDTO() {
    }

    public CourseDTO(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
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

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
