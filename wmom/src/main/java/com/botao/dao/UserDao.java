package com.botao.dao;

import com.botao.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    /**
     * 用户添加
     * @param connection 连接对象
     * @param user 用户
     * @return
     */
    public int addUser(Connection connection , User user) throws SQLException;

    /**
     * 查询所有的用户
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<User> getAllUsers(Connection connection) throws SQLException;

    /**
     * 根据用户id查询用户信息
     * @param connection 连接对象
     * @param id
     * @return
     * @throws SQLException
     */
    public User getUserById(Connection connection , String id) throws SQLException;

    /**
     * 根据username获取用户信息
     * @param connection
     * @param username
     * @return
     * @throws SQLException
     */
    public User getUserByUserName(Connection connection , String username) throws SQLException;

    /**
     * 通过id更新用户
     * @param connection
     * @param user
     * @return
     * @throws SQLException
     */
    public int UpdateUserById(Connection connection , User user) throws SQLException;
}
