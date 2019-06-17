package top.sl.tmpp.acquire.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.entity.Department;
import top.sl.tmpp.common.entity.DepartmentExample;
import top.sl.tmpp.common.mapper.DepartmentMapper;
import top.sl.tmpp.acquire.service.DepartmentService;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/17 9:30
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<Department> getAllDepartment() {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andIdIsNotNull();
        logger.debug("查询所有授课部门");
        return departmentMapper.selectByExample(departmentExample);
    }
}
