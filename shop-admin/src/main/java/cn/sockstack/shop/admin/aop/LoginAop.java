package cn.sockstack.shop.admin.aop;

import cn.sockstack.shop.admin.enums.SessionEnum;
import cn.sockstack.shop.admin.exceptions.ApiExcetion;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@Aspect
public class LoginAop {
    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    /**
     * 登录检查切入点
     */
    @Pointcut(value = "execution(public * cn.sockstack.shop.admin.controllers.*.*(..))" +
            "&& !execution(public * cn.sockstack.shop.admin.controllers.error.index(..))" +
            "&& !execution(public * cn.sockstack.shop.admin.controllers.login.*(..))"
    )
    public void checkLogin() {}

    /**
     * 已经登录检查切入点
     */
    @Pointcut(value = "execution(public * cn.sockstack.shop.admin.controllers.login.*(..))" +
            "&& !execution(public * cn.sockstack.shop.admin.controllers.login.logout(..))"
    )
    public void login() {}

    /**
     * 访问前检查是否登录
     * @throws ApiExcetion
     * @throws IOException
     */
    @Before(value = "checkLogin()")
    public void doCheckLogin() throws ApiExcetion, IOException {
        HttpSession session = request.getSession();
        Object username = session.getAttribute(SessionEnum.SESSION_NAME.getName());
        if (null == username) {
            if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                throw new ApiExcetion("请登录");
            } else {
                response.sendRedirect("/login");
            }
        }
    }

    /**
     * 如果登录了就直接跳到对应的页面
     * @throws IOException
     */
    @Before(value = "login()")
    public void isLogin() throws IOException {
        System.out.println(request.getRequestURL());
        HttpSession session = request.getSession();
        Object username = session.getAttribute(SessionEnum.SESSION_NAME.getName());
        System.out.println(username);
        if (null != username){
            response.sendRedirect("/");
        }
    }
}

