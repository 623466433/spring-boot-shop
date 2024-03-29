package cn.sockstack.shop.admin.controllers;

import cn.sockstack.shop.admin.enums.LoginStatus;
import cn.sockstack.shop.admin.enums.SessionEnum;
import cn.sockstack.shop.admin.enums.Status;
import cn.sockstack.shop.admin.exceptions.ApiExcetion;
import cn.sockstack.shop.admin.exceptions.WebException;
import cn.sockstack.shop.admin.vo.ResultInfo;
import cn.sockstack.shop.data.entity.Admin;
import cn.sockstack.shop.services.exceptions.InvalidParamException;
import cn.sockstack.shop.services.services.admin.AdminService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class login {
    @Autowired
    AdminService adminService;

    /**
     * 显示登陆页面
     * @return
     * @throws WebException
     */
    @GetMapping(value = "/login")
    public String showLogin() {
        return "login";
    }

    /**
     * 执行登陆操作
     * @param resultInfo
     * @return
     */
    @PostMapping(value = "login")
    @ResponseBody
    public ResultInfo<Admin> doLogin(
            ResultInfo<Admin> resultInfo,
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            HttpSession session
    ) throws ApiExcetion {

        try {
            //1、登陆
            Admin admin = adminService.doLogin(username, password);
            //2、设置session
            admin.setPassword("********");
            session.setAttribute(SessionEnum.SESSION_NAME.getName(), admin);

            resultInfo.setCode(LoginStatus.SUCCESS.getCode());
            resultInfo.setMessage(LoginStatus.SUCCESS.getMessage());
            resultInfo.setData(admin);

            return resultInfo;
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new cn.sockstack.shop.admin.exceptions.ApiExcetion(e.getMessage());
        } catch (InvalidParamException e) {
            e.printStackTrace();
            throw new cn.sockstack.shop.admin.exceptions.ApiExcetion(e.getMessage());
        }

    }

    @PostMapping(value = "logout")
    @ResponseBody
    public ResultInfo<String> logout(HttpSession session) {
        session.setAttribute(SessionEnum.SESSION_NAME.getName(), null);

        ResultInfo<String> resultInfo = new ResultInfo<>();
        resultInfo.setCode(Status.SUCCESS.getCode());
        resultInfo.setMessage(Status.SUCCESS.getMessage());
        resultInfo.setData("");

        return  resultInfo;
    }
}
