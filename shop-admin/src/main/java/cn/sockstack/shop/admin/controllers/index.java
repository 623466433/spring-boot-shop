package cn.sockstack.shop.admin.controllers;

import cn.sockstack.shop.data.entity.Admin;
import cn.sockstack.shop.services.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class index {
    @Autowired
    AdminService adminService;

    @GetMapping(value = "/")
    public String index() {
        System.out.println("this is admin module index controller");
        Admin admin =adminService.getAdminInfoByUsername("abcd");
        System.out.println(admin);
        if (null != admin) {
            System.out.println(admin.getId());
            System.out.println(admin.getUsername());
            System.out.println(admin.getPassword());
            System.out.println(admin.getCreatedAt());
            System.out.println(admin.getUpdatedAt());
        }
        return "hello world";
    }
}
