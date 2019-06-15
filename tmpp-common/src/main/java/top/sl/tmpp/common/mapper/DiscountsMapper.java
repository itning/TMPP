package top.sl.tmpp.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.Discounts;
import top.sl.tmpp.common.entity.DiscountsExample;

public interface DiscountsMapper {
    long countByExample(DiscountsExample example);

    int deleteByExample(DiscountsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Discounts record);

    int insertSelective(Discounts record);

    List<Discounts> selectByExample(DiscountsExample example);

    Discounts selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Discounts record, @Param("example") DiscountsExample example);

    int updateByExample(@Param("record") Discounts record, @Param("example") DiscountsExample example);

    int updateByPrimaryKeySelective(Discounts record);

    int updateByPrimaryKey(Discounts record);
}