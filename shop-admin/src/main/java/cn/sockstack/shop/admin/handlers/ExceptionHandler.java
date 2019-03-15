package cn.sockstack.shop.admin.handlers;

import cn.sockstack.shop.admin.entity.JsonResponseInfo;
import cn.sockstack.shop.admin.enums.Status;
import cn.sockstack.shop.admin.exceptions.ApiExcetion;
import cn.sockstack.shop.admin.exceptions.WebException;
import cn.sockstack.shop.admin.vo.ResultInfo;
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
    public ResultInfo<String> apiException(ApiExcetion excetion) {
        ResultInfo<String> resultInfo = new ResultInfo<>();
        resultInfo.setCode(Status.EXCEPTION.getCode());
        resultInfo.setMessage(excetion.getMessage());
        resultInfo.setData(Status.EXCEPTION.getMessage());

        return resultInfo;
    }
}
