package top.sl.tmpp.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 权限不足/横向越权
 *
 * @author ShuLu
 * @date 2019/6/30 13:05
 */
public class PermissionException extends BaseException {
    public PermissionException() {
        this("FORBIDDEN");
    }

    public PermissionException(String msg) {
        super(msg, HttpStatus.FORBIDDEN);
    }
}
