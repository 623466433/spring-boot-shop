package cn.sockstack.shop.admin.enums;

import lombok.Getter;

@Getter
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
}
