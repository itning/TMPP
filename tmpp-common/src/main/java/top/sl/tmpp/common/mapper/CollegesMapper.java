package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.Colleges;
import top.sl.tmpp.common.entity.CollegesExample;

import java.util.List;

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

    List<Colleges> selectAll();

    String selectIdByName(@Param("name") String name);
}