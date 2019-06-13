package top.sl.tmpp.entity;

public class Colleges {
    private String id;

    private String name;

    public Colleges(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Colleges() {
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
}