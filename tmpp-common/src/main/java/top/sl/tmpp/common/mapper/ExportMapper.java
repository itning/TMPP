package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.pojo.*;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/26 14:12
 */
public interface ExportMapper {
    /**
     * 导出采购教材汇总表
     *
     * @return PurchasingMaterials集合
     */
    List<PurchasingMaterials> getPurchasingMaterials(String executePlanId);

    String selectYear(String executePlanId);

    String selectTerm(String executePlanId);

    List<String> selectClazz(String executePlanId);

    List<StudentReceiveBook> selectStudentReceiveBooks(String clazz);

    List<PublisherStatistics> selectPublishingHouseStatistics(String executePlanId);

    List<SubscriptionBook> selectSubscriptionBook(String executePlanId);

    List<TeacherReceiveBook> selectTeacherReceiveBook(String executePlanId);

    List<SubscriptionBookPlan> selectSubscriptionBookPlan(String executePlanId);

    List<BookMaterials> selectBookMaterials(@Param("year") String year, @Param("college") String college,
                                            @Param("teachingDepartment") String teachingDepartment, @Param("term") Boolean term);

    /**
     * 考试课 课程总门数
     *
     * @param executePlanId 执行计划ID
     * @return list
     */
    List<String> selectTheTotalCourses(String executePlanId);

    /**
     * 考查课 课程总门数
     *
     * @param executePlanId 执行计划ID
     * @return list
     */
    List<String> selectTheStudyCourses(String executePlanId);

    /**
     * 考试课 订购教材课程门数
     *
     * @param executePlanId 执行计划ID
     * @return list
     */
    List<String> selectExaminationCourse(String executePlanId);

    /**
     * 考查课 订购教材课程门数
     *
     * @param executePlanId 执行计划ID
     * @return list
     */
    List<String> selectStudyClass(String executePlanId);

    /**
     * 查找教育层次
     *
     * @param executePlanId 执行计划ID
     * @return 教育层次
     */
    String selectLevel(String executePlanId);
}
