package top.sl.tmpp.acquire.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.entity.Course;
import top.sl.tmpp.common.entity.CourseExample;
import top.sl.tmpp.common.mapper.CourseMapper;
import top.sl.tmpp.acquire.service.CourseService;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/17 11:20
 */
@Service
public class CourseServiceImpl implements CourseService {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public List<Course> getAllCourse() {
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andIdIsNotNull();
        List<Course> courses = courseMapper.selectByExample(courseExample);
        logger.debug("获取所有课程信息");
        return courses;
    }
}
