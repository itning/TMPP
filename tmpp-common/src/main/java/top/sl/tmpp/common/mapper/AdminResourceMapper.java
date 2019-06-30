package top.sl.tmpp.common.mapper;

import top.sl.tmpp.common.entity.AdminResource;

public interface AdminResourceMapper {

    int deleteByPrimaryKey(String id);

    int insert(AdminResource record);

    int insertSelective(AdminResource record);

    AdminResource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminResource record);

    int updateByPrimaryKey(AdminResource record);
}