package top.sl.tmpp.export.service;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ShuLu
 * @date 2019/6/26 10:49
 */
public interface ExportService {
    /**
     * 导出采购教材汇总表
     *
     * @param outputStream  输出流
     * @param executePlanId 执行计划ID
     * @throws IOException IOException
     */
    void procurementTable(String executePlanId, OutputStream outputStream) throws IOException;

    /**
     * 导出学生班级教材信息表
     *
     * @param executePlanId 执行计划ID
     * @param outputStream  输出流
     * @throws IOException IOException
     */
    void studentClassBookTable(String executePlanId, OutputStream outputStream) throws IOException;

    /**
     * 出版社统计数量表
     *
     * @param executePlanId 执行计划ID
     * @param outputStream  输出流
     * @throws IOException IOException
     */
    void publishingHouseStatistics(String executePlanId, OutputStream outputStream) throws IOException;

    /**
     * 教材样书统计表
     *
     * @param executePlanId 执行计划ID
     * @param outputStream  输出流
     * @throws IOException IOException
     */
    void subscriptionBook(String executePlanId, OutputStream outputStream) throws IOException;

    /**
     * 教师领取教材汇总表
     *
     * @param executePlanId 执行计划ID
     * @param outputStream  输出流
     * @throws IOException IOException
     */
    void teacherReceiveBook(String executePlanId, OutputStream outputStream) throws IOException;

    /**
     * 征订教材计划统计表
     *
     * @param executePlanId 执行计划ID
     * @param outputStream  输出流
     * @throws IOException IOException
     */
    void subscriptionBookPlan(String executePlanId, OutputStream outputStream) throws IOException;

    /**
     * 考试/考察/总体订书率表
     *
     * @param executePlanId 执行计划ID
     * @param outputStream  输出流
     * @throws IOException IOException
     */
    void summaryTable(String executePlanId, OutputStream outputStream) throws IOException;

    /**
     * 征订教材汇总表格
     *
     * @param year               年
     * @param college            学院
     * @param teachingDepartment 授课部门
     * @param term               学期
     * @param outputStream       输出流
     * @throws IOException IOException
     */
    void downBookMaterials(String year, String college, String teachingDepartment, Boolean term, OutputStream outputStream) throws IOException;
}
