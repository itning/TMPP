package top.sl.tmpp.common.pojo;

/**
 * 出版社统计数量表
 *
 * @author ShuLu
 * @date 2019/6/26 11:18
 */
public class PublisherStatistics {
    /**
     * 学院名称
     */
    private String collegesName;
    /**
     * 出版社
     */
    private String press;
    /**
     * 总数
     */
    private Integer total;

    public PublisherStatistics() {
    }

    public PublisherStatistics(String collegesName, String press, Integer total) {
        this.collegesName = collegesName;
        this.press = press;
        this.total = total;
    }

    public String getCollegesName() {
        return collegesName;
    }

    public void setCollegesName(String collegesName) {
        this.collegesName = collegesName;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
