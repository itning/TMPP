package top.sl.tmpp.export.service.impl;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.mapper.ExportMapper;
import top.sl.tmpp.common.pojo.PublisherStatistics;
import top.sl.tmpp.common.pojo.PurchasingMaterials;
import top.sl.tmpp.common.pojo.StudentReceiveBook;
import top.sl.tmpp.common.pojo.SubscriptionBook;
import top.sl.tmpp.export.service.ExportService;
import top.sl.tmpp.export.util.Tuple;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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

                StudentReceiveBook book = t.getT2().get(r);
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

    @Override
    public void publishingHouseStatistics(String executePlanId, OutputStream outputStream) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("出版社统计数量表");

        List<PublisherStatistics> publisherStatistics = exportMapper.selectPublishingHouseStatistics(executePlanId);
        HashMap<String, List<PublisherStatistics>> map = new HashMap<>();
        LinkedList<String> strings = new LinkedList<>();
        publisherStatistics.forEach(p -> {
            if (map.get(p.getCollegesName()) != null) {
                List<PublisherStatistics> list = map.get(p.getCollegesName());
                list.add(p);
                map.put(p.getCollegesName(), list);
            } else {
                ArrayList<PublisherStatistics> list = new ArrayList<>();
                list.add(p);
                map.put(p.getCollegesName(), list);
                strings.add(p.getCollegesName());
            }
        });
        XSSFRow row = sheet.createRow(0);
        final String[] headerStrArray = {"", "出版社名称", "订购教材种类总数"};
        information(headerStrArray, row, 0);
        int rowNum = 1;
        for (int i = 0; i < map.size(); i++) {
            String s = strings.get(i);
            if (map.get(s).size() > 1) {
                sheet.addMergedRegion(new CellRangeAddress(1, map.get(s).size(), 0, 0));
            }
            for (int j = 0; j < map.get(s).size(); j++) {
                XSSFRow row1 = sheet.createRow(rowNum++);
                row1.createCell(0).setCellValue(s);
                PublisherStatistics p = map.get(s).get(j);
                row1.createCell(1).setCellValue(p.getPress());
                row1.createCell(2).setCellValue(p.getTotal());

            }
        }
        wb.write(outputStream);
    }

    @Override
    public void subscriptionBook(String executePlanId, OutputStream outputStream) throws IOException {
        List<SubscriptionBook> subscriptionBooks = exportMapper.selectSubscriptionBook(executePlanId);

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("教材样书统计表");

        XSSFRow row = sheet.createRow(0);

        final String[] headerStrArray = {"序号", "授课部门名称", "课程名称", "课程类型"
                , "专业", "教材名称", "作者"
                , "出版社", "书籍编号", "出版日期"
                , "获奖信息", "单价", "使用年级"
                , "教务处样书", "征订人", "征订人电话", "备注"};

        mergeCells(sheet, headerStrArray.length - 1);
        XSSFCell cell = getCellWithStyle(wb, row);
        cell.setCellValue(exportMapper.selectYear(executePlanId) + "学年第" +
                ("0".equals(exportMapper.selectTerm(executePlanId)) ? "一" : "二") + "学期征订教材样书表");
        row = sheet.createRow(1);
        information(headerStrArray, row, 0);
        getSheetByList(subscriptionBooks, sheet);
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

    private void information(String[] strings, XSSFRow row, int index) {
        if (index == 0) {
            for (int i = 0; i < strings.length; i++) {
                row.createCell(i, CellType.STRING).setCellValue(strings[i]);
            }
        } else {
            for (int i = 0; i < strings.length; i++) {
                if (i == 0) {
                    row.createCell(i, CellType.NUMERIC).setCellValue(index);
                }
                row.createCell(i + 1, CellType.STRING).setCellValue(strings[i]);
            }
        }
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
}
