package cn.sockstack.shop.data.repository;

import cn.sockstack.shop.data.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findAdminByUsername(String username);
}
