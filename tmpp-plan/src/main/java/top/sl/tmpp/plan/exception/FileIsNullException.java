package top.sl.tmpp.plan.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * @author ShuLu
 * @date 2019/6/17 15:38
 */
public class FileIsNullException extends BaseException {
    public FileIsNullException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
