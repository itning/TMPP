package top.sl.tmpp.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.PlanStatus;
import top.sl.tmpp.common.entity.PlanStatusExample;

public interface PlanStatusMapper {
    long countByExample(PlanStatusExample example);

    int deleteByExample(PlanStatusExample example);

    int deleteByPrimaryKey(String id);

    int insert(PlanStatus record);

    int insertSelective(PlanStatus record);

    List<PlanStatus> selectByExample(PlanStatusExample example);

    PlanStatus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PlanStatus record, @Param("example") PlanStatusExample example);

    int updateByExample(@Param("record") PlanStatus record, @Param("example") PlanStatusExample example);

    int updateByPrimaryKeySelective(PlanStatus record);

    int updateByPrimaryKey(PlanStatus record);
}