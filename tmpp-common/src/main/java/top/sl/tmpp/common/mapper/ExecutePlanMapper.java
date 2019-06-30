package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.ExecutePlan;
import top.sl.tmpp.common.pojo.ExecutePlanDTO;

import java.util.List;

public interface ExecutePlanMapper {
    int deleteByPrimaryKey(String id);

    int insert(ExecutePlan record);

    int insertSelective(ExecutePlan record);

    ExecutePlan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExecutePlan record);

    int updateByPrimaryKeyWithBLOBs(ExecutePlan record);

    int updateByPrimaryKey(ExecutePlan record);

    List<ExecutePlanDTO> selectAll();

    List<String> selectDistinctYear();

    List<Integer> selectTermByYear(@Param("year") String year);

    ExecutePlan selectFileById(@Param("id") String id);

    List<ExecutePlanDTO> selectByStatus(@Param("status") Boolean status);
}