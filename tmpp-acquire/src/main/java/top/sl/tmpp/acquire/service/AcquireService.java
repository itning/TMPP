package top.sl.tmpp.acquire.service;

import com.github.pagehelper.PageInfo;
import top.sl.tmpp.common.entity.*;
import top.sl.tmpp.common.pojo.ExecutePlanDTO;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/24 14:41
 */
public interface AcquireService {
    /**
     * 获取所有学院
     *
     * @return colleges
     */
    List<Colleges> getAllCollege();

    /**
     * 获取所有课程
     *
     * @param executePlanId 执行计划ID
     * @return 所有课程集合
     */
    List<Course> getAllCourse(String executePlanId);

    /**
     * 获取所有授课部门
     *
     * @return departments
     */
    List<Department> getAllDepartment();

    /**
     * 执行计划
     *
     * @param page 页码
     * @param size 数量
     * @return 执行计划集合
     */
    PageInfo<ExecutePlanDTO> getAllExecutePlan(int page, int size);

    /**
     * 获取所有层次
     *
     * @return 所有层次集合
     */
    List<Level> getAllLevel();

    /**
     * 获取未完成执行计划
     *
     * @return 未完成执行计划集合
     */
    List<ExecutePlanDTO> getAllUnDoneExecutePlan();

    /**
     * 获取执行计划年
     *
     * @return 执行计划年集合
     */
    List<String> getYears();

    /**
     * 获取计划学期
     *
     * @param year 学年
     * @return 计划学期
     */
    List<Integer> getTerms(String year);

    /**
     * 获取已完成执行计划
     *
     * @return 已完成执行计划集合
     */
    List<ExecutePlanDTO> getAllDoneExecutePlan();
}
