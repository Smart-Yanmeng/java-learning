package com.botao.dao.impl;

import com.botao.dao.CartDao;
import com.botao.pojo.Cart;
import com.botao.pojo.Product;
import com.botao.utils.Helper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    @Override
    public int addCat(Connection connection, String productId, String userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into cart (id, productid, userid, created) value (?,?,?,?)");
        preparedStatement.setString(1, Helper.getUUID());
        preparedStatement.setString(2, productId);
        preparedStatement.setString(3, userId);
        preparedStatement.setDate(4, Helper.getSqlDate());
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        return i;
    }

    @Override
    public List<String> getCartsByUserId(Connection connection, String userId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select productid from cart where userid='" + userId + "' and deleted is null");
        ArrayList<String> lsit = new ArrayList<String>();
        while (resultSet.next()) {
            String productid = resultSet.getString("productid");
            lsit.add(productid);
        }
        return lsit;
    }

    @Override
    public int deleteCartById(Connection connection, String productId, String userId) throws SQLException {
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate("update cart set deleted =now() where userid='" + userId + "' and productid='" + productId + "'");
        statement.close();
        return i;
    }

    @Override
    public Cart getCartByProductId(Connection connection, String productId, String userId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from cart where productid='" + productId + "' and userid='" + userId + "' and deleted is null");
        Cart cart = null;
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String productid = resultSet.getString("productid");
            String userid = resultSet.getString("userid");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            cart = new Cart(id, productid, userid, created, deleted);
        }
        return cart;
    }
}
