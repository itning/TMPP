package top.sl.tmpp.plan.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;
import top.sl.tmpp.plan.exception.FileException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ShuLu
 * @date 2019/6/17 13:59
 */
public class FileUtil {
    /**
     * 获取文件扩展名
     *
     * @param file {@link MultipartFile}
     * @return 文件扩展名
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

    /**
     * 检查改文件是否是Excel文件
     *
     * @param file {@link MultipartFile}
     * @return 是返回真
     */
    public static boolean isExcelType(MultipartFile file) {
        String fileType = FileUtil.getExtensionName(file);
        if (".xls".equals(fileType)) {
            return true;
        } else {
            return ".xlsx".equals(fileType);
        }
    }

    /**
     * 判断文件格式
     *
     * @param inStr    {@link InputStream}
     * @param fileName 文件名
     * @return {@link Workbook}
     * @throws IOException IOException
     */
    public static Workbook getWorkbook(InputStream inStr, String fileName) throws IOException {
        Workbook workbook;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new FileException("文件格式不正确", HttpStatus.BAD_REQUEST);
        }
        return workbook;
    }

    public static String getFileMd5(byte[] bytes) {
        return DigestUtils.md5DigestAsHex(bytes);
    }
}
