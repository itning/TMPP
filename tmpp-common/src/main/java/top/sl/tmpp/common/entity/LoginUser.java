package top.sl.tmpp.common.entity;

public class LoginUser {
    /**
     * 学生用户
     */
    public static final String STUDENT_USER = "99";

    private String id;

    private String name;

    private String userType;

    public LoginUser(String id, String name, String userType) {
        this.id = id;
        this.name = name;
        this.userType = userType;
    }

    public LoginUser() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}