package top.sl.tmpp.plan.exception;

import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

/**
 * @author ShuLu
 * @date 2019/6/23 13:52
 */
public class AddPlanException extends BaseException {
    public AddPlanException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
