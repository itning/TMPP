package top.sl.tmpp.acquire.service;


import top.sl.tmpp.common.entity.Course;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/17 11:21
 */
public interface CourseService {
    /**
     *
     * 获取所有学院
     * @return
     */
    List<Course> getAllCourse();
}
