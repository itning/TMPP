package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.Plan;
import top.sl.tmpp.common.entity.PlanExample;

import java.util.List;

public interface PlanMapper {
    long countByExample(PlanExample example);

    int deleteByExample(PlanExample example);

    int deleteByPrimaryKey(String id);

    int insert(Plan record);

    int insertSelective(Plan record);

    List<Plan> selectByExample(PlanExample example);

    Plan selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Plan record, @Param("example") PlanExample example);

    int updateByExample(@Param("record") Plan record, @Param("example") PlanExample example);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKey(Plan record);

    long countByCourseId(@Param("courseId") String courseId);
}