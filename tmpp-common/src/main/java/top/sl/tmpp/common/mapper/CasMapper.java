package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.AdminResource;
import top.sl.tmpp.common.entity.AdminUser;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/24 15:14
 */
public interface CasMapper {
    List<AdminResource> getResourcesByUserName(@Param("username") String username);

    AdminUser selectByUserName(@Param("username") String username);

    List<AdminResource> getResourcesByUserTypeIsTeacher();
}
