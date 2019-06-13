package top.sl.tmpp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.entity.Colleges;
import top.sl.tmpp.entity.CollegesExample;

public interface CollegesMapper {
    long countByExample(CollegesExample example);

    int deleteByExample(CollegesExample example);

    int deleteByPrimaryKey(String id);

    int insert(Colleges record);

    int insertSelective(Colleges record);

    List<Colleges> selectByExample(CollegesExample example);

    Colleges selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Colleges record, @Param("example") CollegesExample example);

    int updateByExample(@Param("record") Colleges record, @Param("example") CollegesExample example);

    int updateByPrimaryKeySelective(Colleges record);

    int updateByPrimaryKey(Colleges record);
}