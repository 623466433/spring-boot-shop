package cn.sockstack.shop.admin.controllers;

import cn.sockstack.shop.admin.enums.SessionEnum;
import cn.sockstack.shop.data.entity.Admin;
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
    public String admin(HttpSession session, Model model) {
        Admin admin = (Admin) session.getAttribute(SessionEnum.SESSION_NAME.getName());
        if (null != admin) {
            model.addAttribute("username", admin.getUsername());
        }

        return "index";
    }

    @GetMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }
}
