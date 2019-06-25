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
import java.io.*;
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

    @GetMapping("/down_executeplan")
    public void downPlan(String id, HttpServletResponse response) throws Exception {
        if (id == null || "".equals(id)) {
            throw new FileException("下载失败：参数为空！", HttpStatus.NOT_FOUND);
        }
        ExecutePlan executePlan = referPlanService.downloadExecutePlan(id);
        byte[] file = executePlan.getFile();
        InputStream inputStream = new ByteArrayInputStream(file);
        response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Content-Disposition"
                , "attachment;filename="
                        + new String(("执行计划." + executePlan.getFileType()).getBytes(), StandardCharsets.ISO_8859_1));
        response.setContentType(FileUtil.getContentTypeByExtensionName(executePlan.getFileType()));
        try (OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
             InputStream fis = new BufferedInputStream(inputStream)) {
            IOUtils.copy(fis, toClient);
            toClient.flush();
        } catch (Exception e) {
            if (!e.getMessage().contains("连接")) {
                throw e;
            }
        }
    }

    @DeleteMapping("/executeplan")
    public ResponseEntity<?> removeExecutePlan(String id) {
        referPlanService.removeExecutePlan(id);
        return RestModel.noContent();
    }
}
