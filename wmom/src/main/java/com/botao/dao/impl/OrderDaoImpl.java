package com.botao.dao.impl;

import com.botao.dao.OrderDao;
import com.botao.pojo.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 大量的重复代码
 * 可以考虑sql拼接
 * ----》mybatis
 */
public class OrderDaoImpl implements OrderDao {
    @Override
    public List<Order> getAllOrders(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from `order` order by created desc");
        List<Order> orders = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String productid = resultSet.getString("productid");
            String userid = resultSet.getString("userid");
            Integer number = resultSet.getInt("number");
            String addr = resultSet.getString("addr");
            Integer status = resultSet.getInt("status");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            orders.add(new Order(id, productid, userid, number, addr, status, created, deleted));
        }
        resultSet.close();
        statement.close();
        return orders;
    }

    @Override
    public Order getOrderById(Connection connection, String id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from `order` where id='" + id + "'");
        Order order = null;
        while (resultSet.next()) {
            String id1 = resultSet.getString("id");
            String productid = resultSet.getString("productid");
            String userid = resultSet.getString("userid");
            Integer number = resultSet.getInt("number");
            String addr = resultSet.getString("addr");
            Integer status = resultSet.getInt("status");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            order = new Order(id1, productid, userid, number, addr, status, created, deleted);
        }
        resultSet.close();
        statement.close();
        return order;
    }

    @Override
    public List<Order> getOrdersByUserId(Connection connection, String userId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from `order` where userid='"+userId+"' and deleted is null order by created desc");
        List<Order> orders = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String productid = resultSet.getString("productid");
            String userid = resultSet.getString("userid");
            Integer number = resultSet.getInt("number");
            String addr = resultSet.getString("addr");
            Integer status = resultSet.getInt("status");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            orders.add(new Order(id, productid, userid, number, addr, status, created, deleted));
        }
        resultSet.close();
        statement.close();
        return orders;
    }

    @Override
    public List<Order> getOrdersByStatus(Connection connection, Integer status) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from `order` where status='"+status+"'");
        List<Order> orders = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String productid = resultSet.getString("productid");
            String userid = resultSet.getString("userid");
            Integer number = resultSet.getInt("number");
            String addr = resultSet.getString("addr");
            Integer status1 = resultSet.getInt("status");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            orders.add(new Order(id, productid, userid, number, addr, status1, created, deleted));
        }
        resultSet.close();
        statement.close();
        return orders;
    }

    @Override
    public List<Order> getOrdersByUserIdAndStatus(Connection connection, String userId, Integer status) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from `order` where userid='"+userId+"' and status='"+status+"'");
        List<Order> orders = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String productid = resultSet.getString("productid");
            String userid = resultSet.getString("userid");
            Integer number = resultSet.getInt("number");
            String addr = resultSet.getString("addr");
            Integer status1 = resultSet.getInt("status");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            orders.add(new Order(id, productid, userid, number, addr, status1, created, deleted));
        }
        resultSet.close();
        statement.close();
        return orders;
    }

    @Override
    public int addOrder(Connection connection, Order order) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into `order` (id, productid, userid, number, addr, status, created, deleted) VALUE (?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,order.getId());
        preparedStatement.setString(2,order.getProductid());
        preparedStatement.setString(3,order.getUserid());
        preparedStatement.setInt(4,order.getNumber());
        preparedStatement.setString(5,order.getAddr());
        preparedStatement.setInt(6,order.getStatus());
        preparedStatement.setDate(7,(java.sql.Date)order.getCreated());
        preparedStatement.setDate(8,(java.sql.Date)order.getDeleted());
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        return i;
    }

    @Override
    public int updateStatus(Connection connection,String id, int i) throws SQLException {
        Statement statement = connection.createStatement();
        int i1 = statement.executeUpdate("update `order` set status =" + i + " where id='" + id + "'");
        statement.close();
        return i1;
    }

    @Override
    public int deleteOrder(Connection connection, String id) throws SQLException {
        Statement statement = connection.createStatement();
        int i1 = statement.executeUpdate("update `order` set deleted =NOW() where id='" + id + "'");
        statement.close();
        return i1;
    }

    @Override
    public int getNum(Connection connection, String id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(*) from `order` where productid='" + id + "'");
        int num = 0 ;
        while (resultSet.next()){
            num = resultSet.getInt(1);
        }
        return num;
    }
}
