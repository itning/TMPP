package top.sl.tmpp.plan.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * @author ShuLu
 * @date 2019/6/24 20:10
 */
public class ExcelReadException extends BaseException {
    /**
     * @param row  行
     * @param cell 列
     */
    public ExcelReadException(int row, int cell, String msg) {
        super("第" + row + "行第" + cell + "列 " + msg, HttpStatus.BAD_REQUEST);
    }

    public ExcelReadException(int row, int cell) {
        this(row, cell, "为空");
    }
}
