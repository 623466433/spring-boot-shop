package cn.sockstack.shop.services.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.sockstack.shop.data", "cn.sockstack.shop.services"})
public class ShopServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServicesApplication.class, args);
    }

}
