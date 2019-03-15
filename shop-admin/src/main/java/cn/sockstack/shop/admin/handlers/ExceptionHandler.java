package cn.sockstack.shop.admin.handlers;

import cn.sockstack.shop.admin.entity.JsonResponseInfo;
import cn.sockstack.shop.admin.enums.Status;
import cn.sockstack.shop.admin.exceptions.ApiExcetion;
import cn.sockstack.shop.admin.exceptions.WebException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {
    /**
     * 默认报错页面
     */
    private final static String DEFAULT_ERROR_VIEW_NAME = "404";

    @org.springframework.web.bind.annotation.ExceptionHandler(WebException.class)
    public ModelAndView webExceptionHander(WebException exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", exception.getMessage());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW_NAME);

        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ApiExcetion.class)
    public JsonResponseInfo<String> apiException(ApiExcetion excetion) {
        JsonResponseInfo<String> jsonResponseInfo = new JsonResponseInfo<>();
        jsonResponseInfo.setCode(Status.EXCEPTION.getCode());
        jsonResponseInfo.setMessage(excetion.getMessage());
        jsonResponseInfo.setData(Status.EXCEPTION.getMessage());

        return jsonResponseInfo;
    }
}
