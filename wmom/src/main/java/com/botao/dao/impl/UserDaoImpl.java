package com.botao.dao.impl;

import com.botao.dao.UserDao;
import com.botao.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public int addUser(Connection connection, User user) throws SQLException {
        String id = user.getId();
        String username = user.getUsername();
        String name = user.getName();
        String password = user.getPassword();
        String head = user.getHead();
        Integer status = user.getStatus();
        Date created = user.getCreated();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user (id, username, name, password,head, status, created) value (?,?,?,?,?,?,?)");
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, username);
        preparedStatement.setString(3, name);
        preparedStatement.setString(4, password);
        preparedStatement.setString(5, head);
        preparedStatement.setInt(6, status);
        preparedStatement.setDate(7, new java.sql.Date(created.getTime()));
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        return i;
    }

    @Override
    public List<User> getAllUsers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            String id1 = resultSet.getString("id");
            String username = resultSet.getString("username");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String phone = resultSet.getString("phone");
            String head = resultSet.getString("head");
            String addr = resultSet.getString("addr");
            int status = resultSet.getInt("status");
            java.util.Date created = resultSet.getDate("created");
            java.util.Date deleted = resultSet.getDate("deleted");
            users.add(new User(id1, username, name, password, phone, head, addr,status, created, deleted));
        }
        return users;
    }

    @Override
    public User getUserById(Connection connection, String id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user where id='" + id + "'");
        User user = null;
        while (resultSet.next()) {
            String id1 = resultSet.getString("id");
            String username = resultSet.getString("username");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String phone = resultSet.getString("phone");
            String head = resultSet.getString("head");
            String addr = resultSet.getString("addr");
            int status = resultSet.getInt("status");
            java.util.Date created = resultSet.getDate("created");
            java.util.Date deleted = resultSet.getDate("deleted");
            user = new User(id1, username, name, password, phone, head, addr,status, created, deleted);
        }
        resultSet.close();
        statement.close();
        return user;
    }

    @Override
    public User getUserByUserName(Connection connection, String username) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "select * from user where username='" + username + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(sql);
        User user = null;
        while (resultSet.next()) {
            String id1 = resultSet.getString("id");
            String username1 = resultSet.getString("username");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String phone = resultSet.getString("phone");
            String head = resultSet.getString("head");
            String addr = resultSet.getString("addr");
            int status = resultSet.getInt("status");
            java.util.Date created = resultSet.getDate("created");
            java.util.Date deleted = resultSet.getDate("deleted");
            user = new User(id1, username1, name, password, phone, head,addr, status, created, deleted);
        }
        resultSet.close();
        statement.close();
        return user;
    }

    @Override
    public int UpdateUserById(Connection connection, User user) throws SQLException {
        Statement statement = connection.createStatement();
        String id = user.getId();
        String username = user.getUsername();
        String name = user.getName();
        String password = user.getPassword();
        String phone = user.getPhone();
        String head = user.getHead();
        String addr = user.getAddr();
        int i = statement.executeUpdate("update user set username='" + username + "',name='" + name + "',password='" + password + "',phone='" + phone + "',head='" + head +"' ,addr='"+addr+"' where id='"+id+"'");
        statement.close();
        return i;
    }
}
