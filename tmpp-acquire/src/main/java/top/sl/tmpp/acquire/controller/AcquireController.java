package top.sl.tmpp.acquire.controller;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.sl.tmpp.acquire.service.AcquireService;
import top.sl.tmpp.common.entity.*;
import top.sl.tmpp.common.util.RestModel;

import java.util.List;

/**
 * 获取
 *
 * @author ShuLu
 * @date 2019/6/24 14:39
 */
@RestController
public class AcquireController {
    private static final Logger logger = LoggerFactory.getLogger(AcquireController.class);

    private final AcquireService acquireService;

    @Autowired
    public AcquireController(AcquireService acquireService) {
        this.acquireService = acquireService;
    }

    /**
     * 查询所有学院
     *
     * @return ResponseEntity
     */
    @GetMapping("/colleges")
    public ResponseEntity<?> getAllCollege() {
        List<Colleges> colleges = acquireService.getAllCollege();
        logger.debug("查询所有学院成功");
        return RestModel.ok(colleges);
    }

    /**
     * 获取所有课程
     *
     * @param executePlanId 执行计划ID
     * @return ResponseEntity
     */
    @GetMapping("/courseTitles")
    public ResponseEntity<?> getAllCourse(@RequestParam("execute_plan_id") String executePlanId) {
        List<Course> courses = acquireService.getAllCourse(executePlanId);
        logger.debug("查询成功");
        return RestModel.ok(courses);
    }

    /**
     * 获取所有授课部门
     *
     * @return ResponseEntity
     */
    @GetMapping("/teaching_departments")
    public ResponseEntity<?> getAllDepartment() {
        List<Department> departments = acquireService.getAllDepartment();
        logger.debug("获取所有授课部门成功");
        return RestModel.ok(departments);
    }

    /**
     * 获取所有计划列表
     *
     * @param page 页码
     * @param size 数量
     * @return ResponseEntity
     */
    @GetMapping("/execute_plans")
    public ResponseEntity<?> plan(@RequestParam(required = false, defaultValue = "1") int page,
                                  @RequestParam(required = false, defaultValue = "50") int size,
                                  LoginUser loginUser) {
        PageInfo<ExecutePlan> allExecutePlan = acquireService.getAllExecutePlan(page, size);
        return RestModel.ok(allExecutePlan);
    }

    /**
     * 获取所有教育层次
     *
     * @return ResponseEntity
     */
    @GetMapping("/educational_levels")
    public ResponseEntity<?> getAllLevel() {
        List<Level> levels = acquireService.getAllLevel();
        logger.debug("获取所有层次成功");
        return RestModel.ok(levels);
    }

    /**
     * 获取未完成执行计划
     *
     * @return ResponseEntity
     */
    @GetMapping("/undone_execute_plan")
    public ResponseEntity<?> undoneExecutePlan() {
        return RestModel.ok(acquireService.getAllUnDoneExecutePlan());
    }

    /**
     * 获取执行计划年
     *
     * @return ResponseEntity
     */
    @GetMapping("/year")
    public ResponseEntity<?> year() {
        return RestModel.ok(acquireService.getYears());
    }

    /**
     * 获取计划学期
     *
     * @param year 学年
     * @return ResponseEntity
     */
    @GetMapping("/term")
    public ResponseEntity<?> term(@RequestParam String year) {
        return RestModel.ok(acquireService.getTerms(year));
    }

    /**
     * 获取已完成执行计划
     *
     * @return ResponseEntity
     */
    @GetMapping("/done_execute_plan")
    public ResponseEntity<?> doneExecutePlan() {
        return RestModel.ok(acquireService.getAllDoneExecutePlan());
    }
}
