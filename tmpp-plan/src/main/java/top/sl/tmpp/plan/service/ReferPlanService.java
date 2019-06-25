package top.sl.tmpp.plan.service;

import top.sl.tmpp.common.entity.ExecutePlan;

/**
 * @author ShuLu
 * @date 2019/6/17 12:18
 */
public interface ReferPlanService {
    /**
     * 提交执行计划
     *
     * @param year               学年
     * @param term               学期
     * @param teachingDepartment 授课部门
     * @param educationalLevel   教育层次
     * @param fileId             执行计划文件 ID
     */
    void referPlan(String year, boolean term, String teachingDepartment, String educationalLevel, String fileId);

    /**
     * 查询需下载的执行计划
     *
     * @param id 删除的执行计划id
     * @return
     */
    ExecutePlan downloadExecutePlan(String id);

    /**
     * 删除执行计划
     *
     * @param id 删除的执行计划id
     */
    void removeExecutePlan(String id);

}
