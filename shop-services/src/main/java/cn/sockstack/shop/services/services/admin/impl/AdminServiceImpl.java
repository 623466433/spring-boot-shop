package cn.sockstack.shop.services.services.admin.impl;

import cn.sockstack.shop.data.entity.Admin;
import cn.sockstack.shop.data.repository.AdminRepository;
import cn.sockstack.shop.services.exceptions.InvalidParamException;
import cn.sockstack.shop.services.services.admin.AdminService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service()
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    /**
     * 通过用户名获取管理员信息
     * @param username
     * @return
     */
    @Override
    public Admin getAdminInfoByUsername(String username) {
        System.out.println("this is service");
        Admin admin = adminRepository.findAdminByUsername(username);
        return admin;
    }

    /**
     * 执行登陆操作
     * @param username
     * @param password
     * @return
     * @throws NotFoundException
     * @throws InvalidParamException
     */
    @Override
    public Admin doLogin(String username, String password) throws NotFoundException, InvalidParamException {
        Admin admin = adminRepository.findAdminByUsername(username);

        if (null == admin) {
            throw new NotFoundException("管理员不存在");
        }

        if (!admin.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
            throw new InvalidParamException("密码不正确");
        }

        return admin;
    }
}
