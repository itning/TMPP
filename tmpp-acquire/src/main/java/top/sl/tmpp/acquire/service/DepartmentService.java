package top.sl.tmpp.acquire.service;


import top.sl.tmpp.common.entity.Department;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/17 9:30
 */
public interface DepartmentService {
    /**
     * 获取所有授课部门
     * @return departments
     */
    List<Department> getAllDepartment();
}
