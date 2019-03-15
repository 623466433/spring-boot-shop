package cn.sockstack.shop.services.services.admin;

import cn.sockstack.shop.data.entity.Admin;
import cn.sockstack.shop.services.exceptions.InvalidParamException;
import org.apache.ibatis.javassist.NotFoundException;

public interface AdminService {
    /**
     * 通过用户名获取管理员信息
     * @param username
     * @return
     */
    public Admin getAdminInfoByUsername(String username);

    /**
     * 执行登陆操作
     * @param username
     * @param password
     * @return
     * @throws NotFoundException
     * @throws InvalidParamException
     */
    public Admin doLogin(String username, String password) throws NotFoundException, InvalidParamException;
}
