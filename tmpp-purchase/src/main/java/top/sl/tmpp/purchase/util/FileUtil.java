package top.sl.tmpp.purchase.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ShuLu
 * @date 2019/6/17 13:59
 */
public class FileUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 获取文件扩展名
     *
     * @param file
     * @return
     */
    public static String getExtensionName(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String extensionName = "";
        if (originalFilename != null) {
            int i = originalFilename.lastIndexOf(".");
            if (i != -1) {
                extensionName = file.getOriginalFilename().substring(i);
            }
        }
        return extensionName;
    }

    /**
     * 根据文件扩展名获取MIME类型
     *
     * @param extensionName 扩展名
     * @return MIME类型
     */
    public static String getContentTypeByExtensionName(String extensionName) {
        switch (extensionName) {
            case "xls":
                return "application/vnd.ms-excel";
            case "xlsx":
                return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            default:
                return null;
        }
    }

    public static String getFileMD5(byte[] bytes) {
            return DigestUtils.md5DigestAsHex(bytes);
        }
}
