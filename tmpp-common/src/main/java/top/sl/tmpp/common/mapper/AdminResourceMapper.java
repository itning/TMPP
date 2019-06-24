package top.sl.tmpp.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.AdminResource;
import top.sl.tmpp.common.entity.AdminResourceExample;

public interface AdminResourceMapper {
    long countByExample(AdminResourceExample example);

    int deleteByExample(AdminResourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(AdminResource record);

    int insertSelective(AdminResource record);

    List<AdminResource> selectByExample(AdminResourceExample example);

    AdminResource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AdminResource record, @Param("example") AdminResourceExample example);

    int updateByExample(@Param("record") AdminResource record, @Param("example") AdminResourceExample example);

    int updateByPrimaryKeySelective(AdminResource record);

    int updateByPrimaryKey(AdminResource record);
}