package top.sl.tmpp.export.service.impl;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.mapper.ExportMapper;
import top.sl.tmpp.common.pojo.PurchasingMaterials;
import top.sl.tmpp.common.pojo.StudentReceiveBook;
import top.sl.tmpp.export.service.ExportService;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/26 10:49
 */
@Service
public class ExportServiceImpl implements ExportService {
    private final ExportMapper exportMapper;

    public ExportServiceImpl(ExportMapper exportMapper) {
        this.exportMapper = exportMapper;
    }

    @Override
    public void procurementTable(String executePlanId, OutputStream outputStream) throws IOException {
        List<PurchasingMaterials> purchasingMaterials = exportMapper.getPurchasingMaterials(executePlanId);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("导出采购教材汇总表");
        XSSFRow row = sheet.createRow(0);
        CellRangeAddress region1 = new CellRangeAddress(0, 0, (short) 0, (short) 9);
        sheet.addMergedRegion(region1);
        CellStyle style = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 16);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        XSSFCell cell = row.createCell(0, CellType.STRING);
        cell.setCellStyle(style);
        cell.setCellValue(exportMapper.selectYear(executePlanId) + "学年第" +
                ("0".equals(exportMapper.selectTerm(executePlanId)) ? "一" : "二") + "学期采购教材汇总表");
        row = sheet.createRow(1);
        String[] strs = {"序号", "教材名称", "出版社"
                , "作者","书号isbn", "单价",  "学生用书",
                "教师用书", "教务处用书", "购书总数"};
        information(strs, row, 0);
        getSheetByList(purchasingMaterials, sheet);
        wb.write(outputStream);
    }

    private <T> void getSheetByList(List<T> list, XSSFSheet sheet) {
        XSSFRow row;
        for (int r = 2; r < list.size(); r++) {
            int index = r - 1;
            row = sheet.createRow(r);
            try {
                String[] str = getObjectFieldsToArray(list.get(r - 2));
                information(str, row, index);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private <T> String[] getObjectFieldsToArray(T t) throws IllegalAccessException {
        Class<?> tClass = t.getClass();
        Field[] fields = tClass.getDeclaredFields();
        String[] s = new String[fields.length];
        int index = 0;
        for (Field field : fields) {
            field.setAccessible(true);
            String o = field.get(t).toString();
            s[index] = o;
            index++;
        }
        return s;
    }

    @Override
    public void studentClassBookTable(String executePlanId, OutputStream outputStream) throws IOException {
        List<String> strings = exportMapper.selectClazz(executePlanId);
        XSSFWorkbook wb = new XSSFWorkbook();
        for (String s : strings) {
            XSSFSheet sheet = wb.createSheet(s);
            List<StudentReceiveBook> studentReceiveBooks = exportMapper.selectStudentReceiveBooks(s);
            studentReceiveBooks.forEach(x->{
                XSSFRow row = sheet.createRow(0);
                /*CellRangeAddress region1 = new CellRangeAddress(0, 0, (short) 0, (short) 10);
                sheet.addMergedRegion(region1);
                CellStyle style = wb.createCellStyle();
                style.setAlignment(HorizontalAlignment.CENTER);*/
                XSSFCell cell = row.createCell(0, CellType.STRING);
                //cell.setCellStyle(style);
                cell.setCellValue(exportMapper.selectYear(executePlanId) + "学年第" +
                        ("0".equals(exportMapper.selectTerm(executePlanId)) ? "一" : "二") + "学期班级领取教材发书单");
                row = sheet.createRow(1);
                String[] strs = {"序号", "开课院系", "使用班级"
                        , "书号isbn", "教材名称", "出版社"
                        , "单价", "数量","购书总折扣数",  "码洋", "实样"};
                information(strs, row,0);
                getSheetByList(studentReceiveBooks, sheet);
            });
        }
        wb.write(outputStream);
    }

    private void information(String[] strs, XSSFRow row, int index) {
        if (index==0){
            for (int i = 0; i < strs.length; i++) {
                row.createCell(i, CellType.STRING).setCellValue(strs[i]);
            }
        }else {
            int j=1;
            for (int i = 0; i < strs.length; i++) {
                if (i==0){
                    row.createCell(i, CellType.NUMERIC).setCellValue(index);
                }
                row.createCell(i+1, CellType.STRING).setCellValue(strs[i]);
            }

        }

    }
}
