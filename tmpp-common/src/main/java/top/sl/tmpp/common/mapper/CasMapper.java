package top.sl.tmpp.common.mapper;

import top.sl.tmpp.common.entity.AdminResource;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/22 16:08
 */
public interface CasMapper {
    List<AdminResource> getResourcesByUserName(String username);
}
