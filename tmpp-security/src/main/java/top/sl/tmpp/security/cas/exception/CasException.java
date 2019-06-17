package top.sl.tmpp.security.cas.exception;


import org.springframework.http.HttpStatus;

/**
 * CAS 异常
 *
 * @author itning
 * @date 2019/6/17 8:54
 */
public class CasException extends BaseLoginException {
    public CasException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
