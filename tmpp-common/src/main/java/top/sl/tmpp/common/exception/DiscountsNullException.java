package top.sl.tmpp.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author 11578
 */
public class DiscountsNullException extends BaseException {
    public DiscountsNullException(String msg, HttpStatus code) {
        super(msg, code);
    }
}