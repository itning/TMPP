package top.sl.tmpp.exception;

import org.springframework.http.HttpStatus;

public class DiscountsNullException extends BaseException {
    public DiscountsNullException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
