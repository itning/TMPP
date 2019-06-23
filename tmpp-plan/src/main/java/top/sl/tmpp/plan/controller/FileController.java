package top.sl.tmpp.plan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.plan.exception.FileTypeException;
import top.sl.tmpp.plan.service.FileService;
import top.sl.tmpp.plan.util.FileUtil;

/**
 * @author ShuLu
 * @date 2019/6/17 15:10
 */
@RestController
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/plan_file")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
        String s = null;
        try {
            s = fileService.fileUpload(file);
        } catch (Exception e) {
            throw new FileTypeException("上传文件类型有误", HttpStatus.ACCEPTED);
        }
        return RestModel.created("上传成功",null);
    }

}
