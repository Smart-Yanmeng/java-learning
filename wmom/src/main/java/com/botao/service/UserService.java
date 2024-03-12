package com.botao.service;

import com.botao.pojo.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    /**
     * 用户注册
     * @param user 用户对象
     * @return bool
     */
    public Boolean addUser(User user) throws SQLException;

    /**
     * 根据id获取用户
     * @param id
     * @return
     * @throws SQLException
     */
    public User getUserById(String id) throws SQLException;

    /**
     * 获取所有的User
     * @return
     * @throws SQLException
     */
    public List<User> getAllUsers() throws SQLException;

    /**
     * 用户登录
     * @param usename 用户名
     * @param password 密码
     * @return
     * @throws SQLException
     */
    public User login(String usename,String password) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     *
     * @param usename 用户名
     * @param password 密码
     * @param flag 是否对密码进行加密
     * @return
     * @throws SQLException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public User login(String usename,String password,Boolean flag) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * 通过id修改用户
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean UpdateUserById(User user) throws SQLException;



}
