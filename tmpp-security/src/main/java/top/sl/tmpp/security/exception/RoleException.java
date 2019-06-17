package top.sl.tmpp.security.exception;

import org.springframework.http.HttpStatus;

/**
 * @author itning
 * @date 2019/6/17 19:29
 */
public class RoleException extends BaseLoginException {
    public RoleException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
