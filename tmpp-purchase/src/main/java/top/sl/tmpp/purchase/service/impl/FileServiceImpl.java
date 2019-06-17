package top.sl.tmpp.purchase.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.sl.tmpp.purchase.exception.FileIsNullException;
import top.sl.tmpp.purchase.service.FileService;
import top.sl.tmpp.purchase.util.FileUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author ShuLu
 * @date 2019/6/17 15:10
 */
@Service
public class FileServiceImpl implements FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    @Override
    public String fileUpload(MultipartFile multipartFile) {
        logger.debug("upload multipartFile: {} {} ", multipartFile.getContentType(), multipartFile.getSize());
        if (multipartFile.isEmpty()) {
            throw new FileIsNullException("上传文件为空", HttpStatus.ACCEPTED);
        }
        try {
            byte[] bytes = multipartFile.getBytes();
            multipartFile.transferTo(new File(FileUtil.getFileMD5(bytes)
                    +FileUtil.getExtensionName(multipartFile)));
            logger.debug("You successfully uploaded");
            return FileUtil.getFileMD5(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new FileIsNullException("上传文件失败", HttpStatus.ACCEPTED);
    }
}
