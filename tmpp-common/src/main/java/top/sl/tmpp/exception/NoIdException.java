package top.sl.tmpp.exception;

import org.springframework.http.HttpStatus;

public class NoIdException extends BaseException {
    public NoIdException(String msg, HttpStatus code) {
        super(msg, code);
    }
}
