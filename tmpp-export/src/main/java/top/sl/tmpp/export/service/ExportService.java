package top.sl.tmpp.export.service;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ShuLu
 * @date 2019/6/26 10:49
 */
public interface ExportService {
    /**
     * 导出采购教材汇总表
     *
     * @param outputStream 输出流
     * @param executePlanId 执行计划ID
     * @throws IOException
     */
    void procurementTable(String executePlanId, OutputStream outputStream) throws IOException;

    void studentClassBookTable(String executePlanId, OutputStream outputStream) throws IOException;

}
