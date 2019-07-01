package top.sl.tmpp.acquire.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sl.tmpp.acquire.service.AcquireService;
import top.sl.tmpp.common.entity.Colleges;
import top.sl.tmpp.common.entity.Department;
import top.sl.tmpp.common.entity.Level;
import top.sl.tmpp.common.mapper.*;
import top.sl.tmpp.common.pojo.CourseDTO;
import top.sl.tmpp.common.pojo.ExecutePlanDTO;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/24 14:42
 */
@Service
public class AcquireServiceImpl implements AcquireService {
    private static final Logger logger = LoggerFactory.getLogger(AcquireServiceImpl.class);

    private final CollegesMapper collegesMapper;
    private final DepartmentMapper departmentMapper;
    private final ExecutePlanMapper executePlanMapper;
    private final LevelMapper levelMapper;
    private final PlanMapper planMapper;

    @Autowired
    public AcquireServiceImpl(CollegesMapper collegesMapper, DepartmentMapper departmentMapper, ExecutePlanMapper executePlanMapper, LevelMapper levelMapper, PlanMapper planMapper) {
        this.collegesMapper = collegesMapper;
        this.departmentMapper = departmentMapper;
        this.executePlanMapper = executePlanMapper;
        this.levelMapper = levelMapper;
        this.planMapper = planMapper;
    }

    @Override
    public List<Colleges> getAllCollege() {
        List<Colleges> colleges = collegesMapper.selectAll();
        logger.debug("获取所有学院");
        return colleges;
    }

    @Override
    public List<CourseDTO> getAllCourse(String executePlanId) {
        return planMapper.selectCourseByExecutePlanId(executePlanId);
    }

    @Override
    public List<Department> getAllDepartment() {
        logger.debug("查询所有授课部门");
        return departmentMapper.selectAll();
    }

    @Override
    public PageInfo<ExecutePlanDTO> getAllExecutePlan(int page, int size) {
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
    public List<ExecutePlanDTO> getAllUnDoneExecutePlan() {
        return executePlanMapper.selectByStatus(false);
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
    public List<ExecutePlanDTO> getAllDoneExecutePlan() {
        return executePlanMapper.selectByStatus(true);
    }
}
