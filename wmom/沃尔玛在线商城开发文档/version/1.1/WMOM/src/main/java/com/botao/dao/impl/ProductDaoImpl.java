package com.botao.dao.impl;

import com.botao.dao.ProductDao;
import com.botao.pojo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductDaoImpl implements ProductDao {
    @Override
    public int add(Connection connection, Product product) throws SQLException {
        product.setId(UUID.randomUUID().toString().replace("-", ""));
        Date date = new Date(new java.util.Date().getTime());
        product.setCreated(date);
        String id = product.getId();
        String name = product.getName();
        String desc = product.getDesc();
        double price = product.getPrice();
        Integer stock = product.getStock();
        String img = product.getImg();
        Date created = product.getCreated();
        Date deleted = product.getDeleted();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into product value (?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, desc);
        preparedStatement.setDouble(4, price);
        preparedStatement.setInt(5, stock);
        preparedStatement.setString(6, img);
        preparedStatement.setDate(7, created);
        preparedStatement.setDate(8, deleted);
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        return i;
    }

    @Override
    public int remove(Connection connection, String id) throws SQLException {
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate("update product set deleted = now() where id='" + id + "'");
        statement.close();
        return i;
    }

    @Override
    public int update(Connection connection, Product product) {
        return 0;
    }

    @Override
    public Product getProductById(Connection connection, String id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from product where id = '" + id + "'");
        Product product = null;
        while (resultSet.next()) {
            String id1 = resultSet.getString("id");
            String name = resultSet.getString("name");
            String desc = resultSet.getString("desc");
            double price = resultSet.getDouble("price");
            int stock = resultSet.getInt("stock");
            String img = resultSet.getString("img");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            product = new Product(id1, name, desc, price, stock, img, created, deleted);
        }

        connection.close();
        return product;
    }

    @Override
    public List<Product> getAllProducts(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from product");
        ArrayList<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String desc = resultSet.getString("desc");
            double price = resultSet.getDouble("price");
            int stock = resultSet.getInt("stock");
            String img = resultSet.getString("img");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            products.add(new Product(id, name, desc, price, stock, img, created, deleted));
        }
        return products;
    }

    @Override
    public List<Product> getAllProductsExceptDeleted(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from product where deleted IS NULL");
        ArrayList<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String desc = resultSet.getString("desc");
            double price = resultSet.getDouble("price");
            int stock = resultSet.getInt("stock");
            String img = resultSet.getString("img");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            products.add(new Product(id, name, desc, price, stock, img, created, deleted));
        }
        return products;
    }
}
