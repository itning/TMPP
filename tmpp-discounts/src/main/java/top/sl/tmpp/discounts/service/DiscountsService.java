package top.sl.tmpp.discounts.service;

import top.sl.tmpp.common.entity.Discounts;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ShuLu
 */
public interface DiscountsService {
    /**
     * 添加折扣
     * @param discount 折扣信息
     */
    void save(BigDecimal discount);

    /**
     * 获取所有折扣哦
     * @return 折扣集合
     */
    List<Discounts> getAllDiscount();

    /**
     * 删除折扣信息
     * @param id 折扣id
     */
    void remove(String id);

    /**
     *修改折扣
     * @param id 折扣id
     * @param decimal 折扣信息
     */
    void modify(String id,BigDecimal decimal);
}
