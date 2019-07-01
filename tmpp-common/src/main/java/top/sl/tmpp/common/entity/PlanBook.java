package top.sl.tmpp.common.entity;

public class PlanBook {
    private String planId;

    private String bookId;

    public PlanBook(String planId, String bookId) {
        this.planId = planId;
        this.bookId = bookId;
    }

    public PlanBook() {
        super();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }
}