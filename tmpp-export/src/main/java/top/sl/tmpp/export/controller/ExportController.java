package top.sl.tmpp.export.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.sl.tmpp.common.entity.LoginUser;
import top.sl.tmpp.common.exception.EmptyParameterException;
import top.sl.tmpp.export.service.ExportService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author ShuLu
 * @date 2019/6/25 10:42
 */
@Controller
public class ExportController {
    private final ExportService exportService;

    public ExportController(ExportService exportService) {
        this.exportService = exportService;
    }

    /**
     * 设置下载Excel文件响应头
     *
     * @param response {@link HttpServletResponse}
     * @param fileName 文件名
     */
    private void setDownloadExcelHeader(HttpServletResponse response, String fileName) {
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), StandardCharsets.ISO_8859_1));
        response.setContentType("application/octet-stream");
    }

    /**
     * 下载执行计划模板
     *
     * @param response {@link HttpServletResponse}
     */
    @GetMapping("/download_execute_plan_template")
    public void downloadExecutePlanTemplate(LoginUser loginUser, HttpServletResponse response) throws IOException {
        setDownloadExcelHeader(response, "执行计划模板.xlsx");
        String file = this.getClass().getResource("/").getFile() + "execute_plan_template.xlsx";
        FileUtils.copyFile(new File(file), response.getOutputStream());
    }

    /**
     * 导出采购教材汇总表
     *
     * @param executePlanId 执行计划id
     * @param response      {@link HttpServletResponse}
     */
    @GetMapping("/procurement_table")
    public void procurementTable(LoginUser loginUser, @RequestParam("execute_plan_id") String executePlanId, HttpServletResponse response) throws IOException {
        setDownloadExcelHeader(response, "采购教材汇总表.xlsx");
        exportService.procurementTable(executePlanId, response.getOutputStream());
    }

    /**
     * 征订教材汇总表格
     *
     * @param year               年
     * @param college            学院
     * @param teachingDepartment 授课部门
     * @param term               学期
     * @param response           {@link HttpServletResponse}
     */
    @GetMapping("/down_book_materials")
    public void downBookMaterials(LoginUser loginUser,
                                  @RequestParam String year,
                                  @RequestParam String college,
                                  @RequestParam String teachingDepartment,
                                  @RequestParam Boolean term,
                                  HttpServletResponse response) throws IOException {
        if (StringUtils.isBlank(college)) {
            college = null;
        }
        if (StringUtils.isBlank(teachingDepartment)) {
            teachingDepartment = null;
        }
        if (college == null && teachingDepartment == null) {
            throw new EmptyParameterException("学院和开设院系部必须要选择一个");
        }
        setDownloadExcelHeader(response, "征订教材汇总表.xlsx");
        exportService.downBookMaterials(year, college, teachingDepartment, term, response.getOutputStream());
    }

    /**
     * 考试/考查/总体订书率表
     *
     * @param executePlanId 执行计划id
     * @param response      {@link HttpServletResponse}
     */
    @GetMapping("/summary_table")
    public void summaryTable(LoginUser loginUser, @RequestParam("execute_plan_id") String executePlanId, HttpServletResponse response) throws IOException {
        setDownloadExcelHeader(response, "考试-考查-总体订书率表.xlsx");
        exportService.summaryTable(executePlanId, response.getOutputStream());
    }

    /**
     * 征订教材计划统计表
     *
     * @param executePlanId 执行计划id
     * @param response      {@link HttpServletResponse}
     */
    @GetMapping("/textbook_execute_plan_statistics")
    public void textbookPlanStatistics(LoginUser loginUser, @RequestParam("execute_plan_id") String executePlanId, HttpServletResponse response) throws IOException {
        setDownloadExcelHeader(response, "征订教材计划统计表.xlsx");
        exportService.subscriptionBookPlan(executePlanId, response.getOutputStream());
    }

    /**
     * 出版社统计数量表
     *
     * @param executePlanId 执行计划id
     * @param response      {@link HttpServletResponse}
     */
    @GetMapping("/publishing_house_statistics")
    public void publishingHouseStatistics(LoginUser loginUser, @RequestParam("execute_plan_id") String executePlanId, HttpServletResponse response) throws IOException {
        setDownloadExcelHeader(response, "出版社统计数量表.xlsx");
        exportService.publishingHouseStatistics(executePlanId, response.getOutputStream());
    }

    /**
     * 征订教材样书统计表
     *
     * @param executePlanId 执行计划id
     * @param response      {@link HttpServletResponse}
     */
    @GetMapping("/subscription_book")
    public void subscriptionBook(LoginUser loginUser, @RequestParam("execute_plan_id") String executePlanId, HttpServletResponse response) throws IOException {
        setDownloadExcelHeader(response, "征订教材样书统计表.xlsx");
        exportService.subscriptionBook(executePlanId, response.getOutputStream());
    }

    /**
     * 教师领取教材汇总表
     *
     * @param executePlanId 执行计划id
     * @param response      {@link HttpServletResponse}
     */
    @GetMapping("/teacher_receiving_textbook")
    public void teacherReceivingTextbook(LoginUser loginUser, @RequestParam("execute_plan_id") String executePlanId, HttpServletResponse response) throws IOException {
        setDownloadExcelHeader(response, "教师领取教材汇总表.xlsx");
        exportService.teacherReceiveBook(executePlanId, response.getOutputStream());
    }

    /**
     * 学生班级领取教材反馈表
     *
     * @param executePlanId 执行计划id
     * @param response      {@link HttpServletResponse}
     */
    @GetMapping("/student_textbook")
    public void studentTextbook(LoginUser loginUser, @RequestParam("execute_plan_id") String executePlanId, HttpServletResponse response) throws IOException {
        setDownloadExcelHeader(response, "班级领取教材反馈表.xlsx");
        exportService.studentClassBookTable(executePlanId, response.getOutputStream());
    }
}
