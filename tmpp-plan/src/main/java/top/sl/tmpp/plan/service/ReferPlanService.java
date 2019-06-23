package top.sl.tmpp.plan.service;

/**
 * @author ShuLu
 * @date 2019/6/17 12:18
 */
public interface ReferPlanService {
    /**
     * 提交执行计划
     * @param year
     * @param term
     * @param teachingDepartment
     * @param educationalLevel
     * @param fileId
     */
    void referPlan(String year, int term, String teachingDepartment, String educationalLevel, String fileId);
}
