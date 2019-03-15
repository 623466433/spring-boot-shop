package cn.sockstack.shop.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class index {

    /**
     * 首页
     * @return
     */
    @GetMapping(value = "/")
    public String index(HttpSession session, Model model) {
        model.addAttribute("username", session.getAttribute("username"));
        return "index";
    }

    @GetMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }
}
