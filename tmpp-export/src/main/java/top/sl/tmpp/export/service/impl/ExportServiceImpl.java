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
import java.math.BigDecimal;
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
        final String[] headerStrArray = {"序号", "教材名称", "出版社", "作者", "书号isbn", "单价", "学生用书", "教师用书", "教务处用书", "购书总数"};

        mergeCells(sheet, headerStrArray.length - 1);

        XSSFCell cell = getCellWithStyle(wb, row);
        cell.setCellValue(exportMapper.selectYear(executePlanId) + "学年第" +
                ("0".equals(exportMapper.selectTerm(executePlanId)) ? "一" : "二") + "学期采购教材汇总表");
        row = sheet.createRow(1);
        information(headerStrArray, row, 0);
        getSheetByList(purchasingMaterials, sheet);
        wb.write(outputStream);
    }

    /**
     * 合并单元格
     *
     * @param sheet   {@link XSSFSheet}
     * @param lastCol 最后一格
     */
    private void mergeCells(XSSFSheet sheet, int lastCol) {
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, lastCol);
        sheet.addMergedRegion(region);
    }

    private <T> void getSheetByList(List<T> list, XSSFSheet sheet) {
        XSSFRow row;
        for (int r = 0; r < list.size(); r++) {
            int index = r + 1;
            row = sheet.createRow(r + 2);
            try {
                String[] str = getObjectFieldsToArray(list.get(r));
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
        XSSFWorkbook wb = new XSSFWorkbook();
        exportMapper.selectClazz(executePlanId)
                .stream().map(c -> {
            List<StudentReceiveBook> studentReceiveBooks = exportMapper.selectStudentReceiveBooks(c);
            return new Tuple<>(c, studentReceiveBooks);
        }).filter(t -> !t.getT2().isEmpty()).forEach(t -> {
            XSSFSheet sheet = wb.createSheet(t.getT1());
            CellRangeAddress region1 = new CellRangeAddress(0, 0, (short) 0, (short) 10);
            sheet.addMergedRegion(region1);

            XSSFRow row = sheet.createRow(0);
            final String[] strs = {"序号", "开课院系", "使用班级"
                    , "书号isbn", "教材名称", "出版社"
                    , "单价", "数量", "购书总折扣数", "码洋", "实样"};
            XSSFCell cell = getCellWithStyle(wb, row);
            cell.setCellValue(exportMapper.selectYear(executePlanId) + "学年第" +
                    ("0".equals(exportMapper.selectTerm(executePlanId)) ? "一" : "二") + "学期班级领取教材发书单");
            row = sheet.createRow(1);
            information(strs, row, 0);

            for (int r = 0; r < t.getT2().size(); r++) {
                XSSFRow xssfRow = sheet.createRow(r + 2);
                xssfRow.createCell(0).setCellValue(r + 1);

                StudentReceiveBook book = t.t2.get(r);
                BigDecimal s = book.getUnitPrice().multiply(BigDecimal.valueOf(book.getClazzNumber()));
                xssfRow.createCell(1).setCellValue(book.getCollegesName());
                xssfRow.createCell(2).setCellValue(book.getClazz());
                xssfRow.createCell(3).setCellValue(book.getIsbn());
                xssfRow.createCell(4).setCellValue(book.getTextBookName());
                xssfRow.createCell(5).setCellValue(book.getPress());
                xssfRow.createCell(6).setCellValue(book.getUnitPrice().toString());
                xssfRow.createCell(7).setCellValue(book.getClazzNumber());
                xssfRow.createCell(8).setCellValue(book.getDiscounts().toString());
                xssfRow.createCell(9).setCellValue(s.doubleValue());
                xssfRow.createCell(10).setCellValue(s.multiply(book.getDiscounts()).doubleValue());
            }
        });
        wb.write(outputStream);
    }

    private XSSFCell getCellWithStyle(XSSFWorkbook wb, XSSFRow row) {
        CellStyle style = wb.createCellStyle();

        XSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);

        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);

        XSSFCell cell = row.createCell(0, CellType.STRING);
        cell.setCellStyle(style);
        return cell;
    }

    private void information(String[] strs, XSSFRow row, int index) {
        if (index == 0) {
            for (int i = 0; i < strs.length; i++) {
                row.createCell(i, CellType.STRING).setCellValue(strs[i]);
            }
        } else {
            for (int i = 0; i < strs.length; i++) {
                if (i == 0) {
                    row.createCell(i, CellType.NUMERIC).setCellValue(index);
                }
                row.createCell(i + 1, CellType.STRING).setCellValue(strs[i]);
            }
        }
    }

    class Tuple<T1, T2> {
        private T1 t1;
        private T2 t2;

        public Tuple(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        public T1 getT1() {
            return t1;
        }

        public T2 getT2() {
            return t2;
        }
    }
}
