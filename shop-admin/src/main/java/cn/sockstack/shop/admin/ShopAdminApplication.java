package cn.sockstack.shop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.sockstack.shop.services", "cn.sockstack.shop.admin"})
public class ShopAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopAdminApplication.class, args);
    }

}
