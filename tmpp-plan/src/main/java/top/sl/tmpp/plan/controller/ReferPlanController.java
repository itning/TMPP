package top.sl.tmpp.plan.controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.sl.tmpp.common.entity.ExecutePlan;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.plan.exception.FileException;
import top.sl.tmpp.plan.service.ReferPlanService;
import top.sl.tmpp.plan.util.FileUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;


/**
 * @author ShuLu
 * @date 2019/6/17 13:46
 */
@RestController
public class ReferPlanController {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
    private final ReferPlanService referPlanService;

    public ReferPlanController(ReferPlanService referPlanService) {
        this.referPlanService = referPlanService;
    }

    /**
     * 提交执行计划
     *
     * @param year               学年
     * @param term               学期
     * @param teachingDepartment 授课部门
     * @param educationalLevel   教育层次
     * @param fileId             执行计划文件 ID
     * @return ResponseEntity
     */
    @PostMapping("/execute_plan")
    public ResponseEntity<?> plan(@RequestParam String year,
                                  @RequestParam boolean term,
                                  @RequestParam String teachingDepartment,
                                  @RequestParam String educationalLevel,
                                  @RequestParam String fileId) {
        referPlanService.referPlan(year, term, teachingDepartment, educationalLevel, fileId);
        return RestModel.created("提交成功", null);
    }

    /**
     * 下载执行计划
     *
     * @param id       执行计划ID
     * @param response {@link HttpServletResponse}
     */
    @GetMapping("/down_execute_plan")
    public void downPlan(@RequestParam String id, HttpServletResponse response) {
        ExecutePlan executePlan = referPlanService.downloadExecutePlan(id);
        byte[] file = executePlan.getFile();
        String fileName = "执行计划." + executePlan.getFileType();
        response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), StandardCharsets.ISO_8859_1));
        response.setHeader("Content-Length", file.length + "");
        response.setContentType(FileUtil.getContentTypeByExtensionName(executePlan.getFileType()));
        try (ByteArrayInputStream bis = new ByteArrayInputStream(file)) {
            IOUtils.copy(bis, response.getOutputStream());
        } catch (Exception e) {
            if (!e.getMessage().contains("连接")) {
                throw new FileException("下载失败：" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/executeplan")
    public ResponseEntity<?> removeExecutePlan(String id) {
        referPlanService.removeExecutePlan(id);
        return RestModel.noContent();
    }
}
