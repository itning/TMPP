package top.sl.tmpp.acquire.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sl.tmpp.acquire.service.AcquireService;
import top.sl.tmpp.common.entity.*;
import top.sl.tmpp.common.mapper.*;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/24 14:42
 */
@Service
public class AcquireServiceImpl implements AcquireService {
    private static final Logger logger = LoggerFactory.getLogger(AcquireServiceImpl.class);

    private final CollegesMapper collegesMapper;
    private final CourseMapper courseMapper;
    private final DepartmentMapper departmentMapper;
    private final ExecutePlanMapper executePlanMapper;
    private final LevelMapper levelMapper;

    @Autowired
    public AcquireServiceImpl(CollegesMapper collegesMapper, CourseMapper courseMapper, DepartmentMapper departmentMapper, ExecutePlanMapper executePlanMapper, LevelMapper levelMapper) {
        this.collegesMapper = collegesMapper;
        this.courseMapper = courseMapper;
        this.departmentMapper = departmentMapper;
        this.executePlanMapper = executePlanMapper;
        this.levelMapper = levelMapper;
    }

    @Override
    public List<Colleges> getAllCollege() {
        List<Colleges> colleges = collegesMapper.selectAll();
        logger.debug("获取所有学院");
        return colleges;
    }

    @Override
    public List<Course> getAllCourse(String executePlanId) {
        List<Course> courses = courseMapper.selectAllFromExecutePlanId(executePlanId);
        logger.debug("获取所有课程信息");
        return courses;
    }

    @Override
    public List<Department> getAllDepartment() {
        logger.debug("查询所有授课部门");
        return departmentMapper.selectAll();
    }

    @Override
    public PageInfo<ExecutePlan> getAllExecutePlan(int page, int size) {
        return PageHelper
                .startPage(page, size)
                .doSelectPageInfo(executePlanMapper::selectAll);
    }

    @Override
    public List<Level> getAllLevel() {
        List<Level> levels = levelMapper.selectAll();
        logger.debug("查询所有层次");
        return levels;
    }

    @Override
    public List<ExecutePlan> getAllUnDoneExecutePlan() {
        ExecutePlanExample executePlanExample = new ExecutePlanExample();
        executePlanExample.createCriteria().andStatusEqualTo(false);
        return executePlanMapper.selectByExample(executePlanExample);
    }

    @Override
    public List<String> getYears() {
        return executePlanMapper.selectDistinctYear();
    }

    @Override
    public List<Integer> getTerms(String year) {
        return executePlanMapper.selectTermByYear(year);
    }

    @Override
    public List<ExecutePlan> getAllDoneExecutePlan() {
        ExecutePlanExample executePlanExample = new ExecutePlanExample();
        executePlanExample.createCriteria().andStatusEqualTo(true);
        return executePlanMapper.selectByExample(executePlanExample);
    }
}
