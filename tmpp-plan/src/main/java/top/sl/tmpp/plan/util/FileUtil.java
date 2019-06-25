package top.sl.tmpp.plan.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;
import top.sl.tmpp.plan.exception.FileException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
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

    /**
     * 处理上传的文件
     *
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    public static List<List<String>> getBankListByExcel(InputStream in, String fileName) throws Exception {
        List list = new ArrayList<>();
        Workbook work = FileUtil.getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<String> li = new ArrayList<>();
                for (int y = 0; y < 15; y++) {
                    cell = row.getCell(y);
                    li.add(cell.toString());
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }

    public static String getFileMD5(byte[] bytes) {
        return DigestUtils.md5DigestAsHex(bytes);
    }
}
