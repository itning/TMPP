package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.Colleges;

import java.util.List;

public interface CollegesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Colleges record);

    int insertSelective(Colleges record);

    Colleges selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Colleges record);

    int updateByPrimaryKey(Colleges record);

    List<Colleges> selectAll();

    String selectIdByName(@Param("name") String name);
}