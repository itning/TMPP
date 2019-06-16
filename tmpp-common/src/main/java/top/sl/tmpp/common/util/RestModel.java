package top.sl.tmpp.common.util;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Rest 返回消息
 *
 * @author shulu
 */
@Component
public class RestModel<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public RestModel() {
    }

    public RestModel(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestModel(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RestModel(HttpStatus status, String msg, T data) {
        this(status.value(), msg, data);
    }

    public RestModel(T data) {
        this(HttpStatus.OK.value(), "查询成功", data);
    }


    public static <T> ResponseEntity ok(T data) {
        return ResponseEntity.ok(new RestModel<>(data));
    }

    public static <T> ResponseEntity created(String msg, T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new RestModel<>(HttpStatus.CREATED, msg, data));
    }

    public static ResponseEntity noContent() {
        return ResponseEntity.noContent().build();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
