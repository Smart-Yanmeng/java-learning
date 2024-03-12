package com.botao.service.impl;

import com.botao.dao.UserDao;
import com.botao.dao.impl.UserDaoImpl;
import com.botao.pojo.User;
import com.botao.service.UserService;
import com.botao.utils.BaseDao;
import com.botao.utils.Helper;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public Boolean addUser(User user) throws SQLException {
        Connection connection = BaseDao.getConnection();
        user.setId(Helper.getUUID());
        user.setStatus(1);
        user.setHead("/static/img/user.jpg");
        user.setCreated(new Date());
        int i = userDao.addUser(connection, user);
        return i == 1;
    }

    @Override
    public User getUserById(String id) throws SQLException {
        Connection connection = BaseDao.getConnection();
        User user = userDao.getUserById(connection, id);
        connection.close();
        return user;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        Connection connection = BaseDao.getConnection();
        List<User> allUsers = userDao.getAllUsers(connection);
        connection.close();
        return allUsers;
    }

    @Override
    public User login(String usename, String password) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        return login(usename,password,true);
    }
    @Override
    public User login(String usename, String password,Boolean flag) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        Connection connection = BaseDao.getConnection();
        User user = userDao.getUserByUserName(connection, usename);
        if(flag){
            password = Helper.toMd5str(password);
        }
        connection.close();
        if (user == null) {
            return null;
        }
        if (!password.equals(user.getPassword())) {
            return null;
        }
        return user;
    }

    //注意：只有已经登录的用户才可以操作和session的id相同的数据，在控制层做判断！！
    @Override
    public boolean UpdateUserById(User user) throws SQLException {
        Connection connection = BaseDao.getConnection();
        int i = userDao.UpdateUserById(connection, user);
        return i==1;
    }
}
