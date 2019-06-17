package top.sl.tmpp.common.mapper;

import top.sl.tmpp.common.entity.AdminResource;

import java.util.List;

/**
 * @author itning
 * @date 2019/6/17 19:22
 */
public interface CasMapper {
    List<AdminResource> getResourcesByUserName(String username);
}
