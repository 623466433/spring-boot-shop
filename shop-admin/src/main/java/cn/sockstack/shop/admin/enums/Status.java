package cn.sockstack.shop.admin.enums;

import lombok.Data;

public enum Status {
    SUCCESS(2000, "success"),
    FAIL(4000, "fail"),
    EXCEPTION(4001, "发生异常"),
    ;
    private Integer code;
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
