package top.sl.tmpp.common.mapper;

import top.sl.tmpp.common.entity.LoginUser;

public interface LoginUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(LoginUser record);

    int insertSelective(LoginUser record);

    LoginUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoginUser record);

    int updateByPrimaryKey(LoginUser record);
}