package cn.sockstack.shop.admin.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class error implements ErrorController {

    @GetMapping(value = "/error")
    public String index(Model model) {
        model.addAttribute("message", "4 0 4");

        return "404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
