package top.sl.tmpp.common.mapper;

import top.sl.tmpp.common.entity.Discounts;

import java.util.List;

public interface DiscountsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Discounts record);

    int insertSelective(Discounts record);

    Discounts selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Discounts record);

    int updateByPrimaryKey(Discounts record);

    List<Discounts> selectAll();
}