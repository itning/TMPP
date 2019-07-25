package top.sl.tmpp.plan.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ShuLu
 * @date 2019/6/17 15:10
 */
public interface FileService {
    /**
     * 上传执行计划文件
     *
     * @param file {@link MultipartFile}
     * @return 文件名
     */
    String fileUpload(MultipartFile file);
}
