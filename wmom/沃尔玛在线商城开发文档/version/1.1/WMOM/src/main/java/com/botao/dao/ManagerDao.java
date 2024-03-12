package com.botao.dao;

import com.botao.pojo.Manager;

import java.sql.Connection;

/**
 * @author cbt28
 */
public interface ManagerDao {

    /**
     * 通过id获取管理员的信息
     * @param connection
     * @param id
     * @return Manager
     */
    public Manager getManagerById(Connection connection, String id) throws Exception;

    /**
     * 通过username获取管理员的信息
     * @param connection
     * @param username 用户名
     * @return Manager
     * @throws Exception
     */
    public Manager getManagerByUserName(Connection connection, String username) throws Exception;
}
