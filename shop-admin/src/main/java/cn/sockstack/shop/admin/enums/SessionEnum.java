package cn.sockstack.shop.admin.enums;

import lombok.Getter;

@Getter
public enum SessionEnum {
    SESSION_NAME("session:admin"),
    ;
    private String name;

    SessionEnum(String name) {
        this.name = name;
    }
}
