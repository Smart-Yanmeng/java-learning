package com.botao.dao.impl;

import com.botao.dao.ManagerDao;
import com.botao.pojo.Manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManagerDaoImpl implements ManagerDao {
    @Override
    public Manager getManagerById(Connection connection, String id) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from manager where id='" + id + "'");
        Manager manager=null;
        while (resultSet.next()) {
            String id1 = resultSet.getString("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            manager = new Manager(id1, username, password, name, created, deleted);

        }
        resultSet.close();
        statement.close();
        return manager;
    }

    @Override
    public Manager getManagerByUserName(Connection connection, String username) throws Exception {
        Statement statement = connection.createStatement();
        String sql = "select * from manager where username='" + username + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("----->" + sql);
        Manager manager = null;
        while (resultSet.next()) {
            String id1 = resultSet.getString("id");
            String username1 = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            manager = new Manager(id1, username1, password, name, created, deleted);
        }
        resultSet.close();
        statement.close();
        return manager;
    }
}
