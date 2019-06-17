package top.sl.tmpp.acquire.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sl.tmpp.common.entity.Department;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.acquire.service.DepartmentService;
import top.sl.tmpp.acquire.service.impl.DepartmentServiceImpl;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/17 9:32
 */
@RestController
public class DepartmentController {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/teaching_departments")
    public ResponseEntity<?> getAllDepartment(){
        List<Department> departments = departmentService.getAllDepartment();
        logger.debug("获取所有授课部门成功");
        return RestModel.ok(departments);
    }
}
