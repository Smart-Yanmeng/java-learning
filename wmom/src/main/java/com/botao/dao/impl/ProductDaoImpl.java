package com.botao.dao.impl;

import com.botao.dao.ProductDao;
import com.botao.pojo.Product;
import com.botao.utils.BaseDao;
import com.botao.utils.Helper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public int add(Connection connection, Product product) throws SQLException {
        product.setId(Helper.getUUID());
        product.setCreated(Helper.getSqlDate());
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
        resultSet.close();
        statement.close();
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
        resultSet.close();
        statement.close();
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
        resultSet.close();
        statement.close();
        return products;
    }

    @Override
    public List<Product> searchProducts(Connection connection, String keyWords) throws SQLException {
        Connection connection1 = BaseDao.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from product where name like '%" + keyWords + "%' or `desc` like '%" + keyWords + "%'";
        System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        List<Product> products = new ArrayList<>();
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
        resultSet.close();
        statement.close();
        return products;
    }

    @Override
    public Product searchProductsById(Connection connection, String id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from product where id='" + id + "'");
        Product product=null;
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
        resultSet.close();
        statement.close();
        return product;
    }

    @Override
    public int updateProductById(Connection connection, Product product) throws SQLException {
        Statement statement = connection.createStatement();
        String id = product.getId();
        String name = product.getName();
        String desc = product.getDesc();
        double price = product.getPrice();
        Integer stock = product.getStock();
        String img = product.getImg();
        int i = statement.executeUpdate("update product set name='" + name + "',`desc`='" + desc + "',price='" + price + "',stock='" + stock + "',img='" + img + "' where id='" + id + "'");
        statement.close();
        return i;
    }

    @Override
    public int reducedById(Connection connection, String id,int num) throws SQLException {
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate("update product set stock=stock-"+num+" where id='" + id + "'");
        return i;
    }
}
