package top.sl.tmpp.plan.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * @author ShuLu
 * @date 2019/6/23 15:05
 */
public class FileException extends BaseException {

    public FileException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
