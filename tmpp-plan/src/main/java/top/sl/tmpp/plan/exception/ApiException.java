package top.sl.tmpp.plan.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * @author itning
 * @date 2019/7/3 10:35
 */
public class ApiException extends BaseException {
    public ApiException(String msg) {
        super(msg, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
