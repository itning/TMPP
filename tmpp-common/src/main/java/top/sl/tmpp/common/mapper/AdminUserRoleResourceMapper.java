package top.sl.tmpp.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.AdminUserRoleResource;
import top.sl.tmpp.common.entity.AdminUserRoleResourceExample;
import top.sl.tmpp.common.entity.AdminUserRoleResourceKey;

public interface AdminUserRoleResourceMapper {
    long countByExample(AdminUserRoleResourceExample example);

    int deleteByExample(AdminUserRoleResourceExample example);

    int deleteByPrimaryKey(AdminUserRoleResourceKey key);

    int insert(AdminUserRoleResource record);

    int insertSelective(AdminUserRoleResource record);

    List<AdminUserRoleResource> selectByExample(AdminUserRoleResourceExample example);

    AdminUserRoleResource selectByPrimaryKey(AdminUserRoleResourceKey key);

    int updateByExampleSelective(@Param("record") AdminUserRoleResource record, @Param("example") AdminUserRoleResourceExample example);

    int updateByExample(@Param("record") AdminUserRoleResource record, @Param("example") AdminUserRoleResourceExample example);

    int updateByPrimaryKeySelective(AdminUserRoleResource record);

    int updateByPrimaryKey(AdminUserRoleResource record);
}