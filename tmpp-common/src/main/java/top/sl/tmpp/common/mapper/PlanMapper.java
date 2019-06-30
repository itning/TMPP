package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.Plan;

import java.util.List;

public interface PlanMapper {
    int deleteByPrimaryKey(String id);

    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKey(Plan record);

    long countByCourseId(@Param("courseId") String courseId);

    List<Plan> selectByExecutePlanId(String id);

    List<Plan> selectByExecutePlanIdAndCourseId(@Param("executePlanId") String executePlanId, @Param("courseId") String courseId);
}