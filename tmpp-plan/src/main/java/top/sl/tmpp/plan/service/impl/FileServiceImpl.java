package top.sl.tmpp.plan.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.sl.tmpp.plan.entity.CourseEducationalCache;
import top.sl.tmpp.plan.exception.FileIsNullException;
import top.sl.tmpp.plan.exception.FileTypeException;
import top.sl.tmpp.plan.service.FileService;
import top.sl.tmpp.plan.util.FileUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author ShuLu
 * @date 2019/6/17 15:10
 */
@Service
public class FileServiceImpl implements FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String fileUpload(MultipartFile multipartFile) {
        logger.debug("upload multipartFile: {} {} ", multipartFile.getContentType(), multipartFile.getSize());
        if (multipartFile.isEmpty()) {
            throw new FileIsNullException("上传文件为空", HttpStatus.BAD_REQUEST);
        }
        if (!FileUtil.isExcelType(multipartFile)) {
            throw new FileTypeException("上传文件类型有误", HttpStatus.BAD_REQUEST);
        }
        try {
            byte[] bytes = multipartFile.getBytes();
            String fileName = FileUtil.getFileMd5(bytes) + FileUtil.getExtensionName(multipartFile);
            File newFile = new File(System.getProperty("java.io.tmpdir") + File.separator + fileName);
            multipartFile.transferTo(newFile);
            CourseEducationalCache.refreshCourseMap();
            logger.debug("You successfully uploaded");
            return fileName;
        } catch (IOException e) {
            throw new FileIsNullException("上传文件失败:" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
