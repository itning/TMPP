package top.sl.tmpp.plan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.plan.service.FileService;

/**
 * @author ShuLu
 * @date 2019/6/17 15:10
 */
@RestController
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private final FileService fileService;

    public FileController(FileService fileService) {
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
}
