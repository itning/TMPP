package top.sl.tmpp.acquire.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import top.sl.tmpp.common.entity.Course;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.acquire.service.CourseService;
import top.sl.tmpp.acquire.service.impl.DepartmentServiceImpl;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/17 11:21
 */
@RestController
public class CourseController {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courseTitles")
    public ResponseEntity<?> getAllCourse() {
        List<Course> courses = courseService.getAllCourse();
        logger.debug("查询成功");
        return RestModel.ok(courses);
    }
}
