package top.sl.tmpp.plan.controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.sl.tmpp.common.entity.ExecutePlan;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.plan.exception.FileException;
import top.sl.tmpp.plan.service.FileService;
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
public class PlanController {
    private static final Logger logger = LoggerFactory.getLogger(PlanController.class);

    private final ReferPlanService referPlanService;
    private final FileService fileService;

    public PlanController(ReferPlanService referPlanService, FileService fileService) {
        this.referPlanService = referPlanService;
        this.fileService = fileService;
    }

    /**
     * 上传执行计划文件
     *
     * @param file 文件
     * @return ResponseEntity
     */
    @PostMapping("/execute_plan_file")
    public ResponseEntity<?> uploadFile(@RequestParam("planFile") MultipartFile file) {
        return RestModel.created("上传成功", fileService.fileUpload(file));
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
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), StandardCharsets.ISO_8859_1));
        response.setIntHeader("Content-Length", file.length);
        response.setContentType(FileUtil.getContentTypeByExtensionName(executePlan.getFileType()));
        try (ByteArrayInputStream bis = new ByteArrayInputStream(file)) {
            IOUtils.copy(bis, response.getOutputStream());
        } catch (Exception e) {
            if (!e.getMessage().contains("连接")) {
                throw new FileException("下载失败：" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    /**
     * 删除执行计划
     *
     * @param id 执行计划ID
     * @return ResponseEntity
     */
    @DeleteMapping("/execute_plan")
    public ResponseEntity<?> removeExecutePlan(@RequestParam String id) {
        referPlanService.removeExecutePlan(id);
        return RestModel.noContent();
    }
}
