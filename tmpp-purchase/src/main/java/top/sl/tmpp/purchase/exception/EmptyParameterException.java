package top.sl.tmpp.purchase.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * 所需不为空的参数为空
 *
 * @author ShuLu
 * @date 2019/6/24 15:26
 */
public class EmptyParameterException extends BaseException {
    public EmptyParameterException(String msg) {
        super(msg, HttpStatus.BAD_REQUEST);
    }
}
