package top.sl.tmpp.plan.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * @author ShuLu
 * @date 2019/6/23 15:03
 */
public class NoPlanException extends BaseException {
    public NoPlanException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
