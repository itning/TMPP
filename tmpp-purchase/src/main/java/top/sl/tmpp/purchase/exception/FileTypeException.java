package top.sl.tmpp.purchase.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * @author ShuLu
 * @date 2019/6/22 13:32
 */
public class FileTypeException extends BaseException {

    public FileTypeException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
