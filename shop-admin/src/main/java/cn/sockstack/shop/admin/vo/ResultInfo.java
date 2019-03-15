package cn.sockstack.shop.admin.vo;

import lombok.Data;

@Data
public class ResultInfo<T> {

    /** 响应码 */
    private Integer code;

    /** 响应信息 */
    private String message;

    /** 响应数据 */
    private T data;

    public ResultInfo() {
    }

    public ResultInfo(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
