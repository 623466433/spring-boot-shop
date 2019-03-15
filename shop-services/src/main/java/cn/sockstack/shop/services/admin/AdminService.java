package cn.sockstack.shop.services.admin;

import cn.sockstack.shop.data.entity.Admin;

public interface AdminService {
    public Admin getAdminInfoByUsername(String username);
}
