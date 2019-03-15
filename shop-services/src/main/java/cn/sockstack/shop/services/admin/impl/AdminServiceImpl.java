package cn.sockstack.shop.services.admin.impl;

import cn.sockstack.shop.data.entity.Admin;
import cn.sockstack.shop.data.repository.AdminRepository;
import cn.sockstack.shop.services.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin getAdminInfoByUsername(String username) {
        System.out.println("this is service");
        Admin admin = adminRepository.findAdminByUsername(username);
        return admin;
    }

    @Override
    public Admin doLogin(String username, String password) {
        Admin admin = adminRepository.findAdminByUsername(username);
        return null;
    }
}
