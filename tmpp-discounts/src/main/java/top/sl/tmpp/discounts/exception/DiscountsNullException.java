package top.sl.tmpp.discounts.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * @author 11578
 */
public class DiscountsNullException extends BaseException {
    public DiscountsNullException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
