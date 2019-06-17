package top.sl.tmpp.purchase.entity;

/**
 * 学期
 * @author ShuLu
 * @date 2019/6/17 19:28
 */
public enum Term {
    /**
     * 第一学期
     */
    FIRST_SEMESTER(1),
    /**
     * 第二学期
     */
    SECOND_SEMESTER(2);

    private int term;
    private Term(int term){
        this.term=term;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
