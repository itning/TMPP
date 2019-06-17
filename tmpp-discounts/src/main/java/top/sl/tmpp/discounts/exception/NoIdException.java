package top.sl.tmpp.discounts.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * @author ShuLu
 */
public class NoIdException extends BaseException {
    public NoIdException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
