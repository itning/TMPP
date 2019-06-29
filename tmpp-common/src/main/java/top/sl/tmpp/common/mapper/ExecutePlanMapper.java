package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.ExecutePlan;
import top.sl.tmpp.common.entity.ExecutePlanExample;
import top.sl.tmpp.common.pojo.ExecutePlanDTO;

import java.util.List;

public interface ExecutePlanMapper {
    long countByExample(ExecutePlanExample example);

    int deleteByExample(ExecutePlanExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExecutePlan record);

    int insertSelective(ExecutePlan record);

    List<ExecutePlan> selectByExampleWithBLOBs(ExecutePlanExample example);

    List<ExecutePlan> selectByExample(ExecutePlanExample example);

    ExecutePlan selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExecutePlan record, @Param("example") ExecutePlanExample example);

    int updateByExampleWithBLOBs(@Param("record") ExecutePlan record, @Param("example") ExecutePlanExample example);

    int updateByExample(@Param("record") ExecutePlan record, @Param("example") ExecutePlanExample example);

    int updateByPrimaryKeySelective(ExecutePlan record);

    int updateByPrimaryKeyWithBLOBs(ExecutePlan record);

    int updateByPrimaryKey(ExecutePlan record);

    List<ExecutePlanDTO> selectAll();

    List<String> selectDistinctYear();

    List<Integer> selectTermByYear(@Param("year") String year);

    ExecutePlan selectFileById(@Param("id") String id);
}