package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.PlanBook;

public interface PlanBookMapper {
    int insert(PlanBook record);

    int insertSelective(PlanBook record);

    int deleteByPlanId(@Param("planId") String planId);
}