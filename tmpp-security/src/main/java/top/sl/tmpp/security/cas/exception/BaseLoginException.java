package top.sl.tmpp.security.cas.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * 登录时发生的异常
 *
 * @author itning
 * @date 2019/6/17 8:49
 */
public abstract class BaseLoginException extends BaseException {

    public BaseLoginException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
