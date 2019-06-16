package top.sl.tmpp.common.entity;

public class Level {
    private String id;

    private String educationalLevel;

    public Level(String id, String educationalLevel) {
        this.id = id;
        this.educationalLevel = educationalLevel;
    }

    public Level() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel == null ? null : educationalLevel.trim();
    }
}