package top.sl.tmpp.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 非法参数异常
 *
 * @author itning
 * @date 2019/7/2 9:43
 */
public class IllegalParameterException extends BaseException {
    public IllegalParameterException(String msg) {
        super(msg, HttpStatus.BAD_REQUEST);
    }
}
