package top.sl.tmpp.common.mapper;

import top.sl.tmpp.common.entity.AdminUserRoleResource;
import top.sl.tmpp.common.entity.AdminUserRoleResourceKey;

public interface AdminUserRoleResourceMapper {
    int deleteByPrimaryKey(AdminUserRoleResourceKey key);

    int insert(AdminUserRoleResource record);

    int insertSelective(AdminUserRoleResource record);

    AdminUserRoleResource selectByPrimaryKey(AdminUserRoleResourceKey key);

    int updateByPrimaryKeySelective(AdminUserRoleResource record);

    int updateByPrimaryKey(AdminUserRoleResource record);
}