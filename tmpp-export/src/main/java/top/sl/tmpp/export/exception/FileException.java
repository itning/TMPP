package top.sl.tmpp.export.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * @author ShuLu
 * @date 2019/6/26 16:36
 */
public class FileException extends BaseException {
    public FileException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
