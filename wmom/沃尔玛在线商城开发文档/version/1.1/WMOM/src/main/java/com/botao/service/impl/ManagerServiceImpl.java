package com.botao.service.impl;

import com.botao.dao.ManagerDao;
import com.botao.dao.impl.ManagerDaoImpl;
import com.botao.pojo.Manager;
import com.botao.service.ManagerService;
import com.botao.utils.BaseDao;

import java.sql.Connection;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao=new ManagerDaoImpl();

    @Override
    public Manager ManagerLogin(String username, String password) throws Exception {
        Connection connection = BaseDao.getConnection();
        Manager manager = managerDao.getManagerByUserName(connection, username);
        connection.close();
        if(manager==null||!password.equals(manager.getPassword())){
            return null;
        }
        return manager;
    }
}
