package top.sl.tmpp.purchase.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ShuLu
 * @date 2019/6/17 15:10
 */
public interface FileService {
    /**
     * 上传执行计划文件
     * @param file
     * @return
     */
    String fileUpload(MultipartFile file);
}
