package top.sl.tmpp.common.exception;

import org.springframework.http.HttpStatus;

/**
 * ID不存在
 *
 * @author ShuLu
 * @date 2019/6/30 13:07
 */
public class IdNotFoundException extends BaseException {
    public IdNotFoundException(String id) {
        super("ID:" + id + "不存在", HttpStatus.BAD_REQUEST);
    }
}
