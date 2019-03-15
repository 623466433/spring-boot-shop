package cn.sockstack.shop.admin.entity;

import lombok.Data;

@Data
public class JsonResponseInfo<T> {
    private Integer code;
    private String message;
    private T data;

    public JsonResponseInfo() {
    }

    public JsonResponseInfo(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
