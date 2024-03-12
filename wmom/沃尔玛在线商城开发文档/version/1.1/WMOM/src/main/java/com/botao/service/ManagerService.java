package com.botao.service;


import com.botao.pojo.Manager;

import java.sql.SQLException;

public interface ManagerService {

    /**
     * 管理员登录验证
     * @param username 用户名
     * @param password 密码
     * @return Manager或者null
     */
    public Manager ManagerLogin(String username,String password) throws Exception;
}
