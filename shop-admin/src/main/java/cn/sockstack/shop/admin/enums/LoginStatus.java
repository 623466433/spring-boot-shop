package cn.sockstack.shop.admin.enums;

import lombok.Getter;

@Getter
public enum  LoginStatus {
    SUCCESS(2000, "登陆成功"),
    FAIL(200, "登陆成功"),
        ;
    private Integer code;
    private String message;

    LoginStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
