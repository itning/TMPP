package top.sl.tmpp.common.mapper;

import top.sl.tmpp.common.entity.Level;

import java.util.List;

public interface LevelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);

    List<Level> selectAll();
}