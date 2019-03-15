package cn.sockstack.shop.admin.controllers;

import cn.sockstack.shop.admin.exceptions.WebException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class login {
    @GetMapping(value = "/login")
    public String showLogin() throws WebException {
        return "login";
    }
}
