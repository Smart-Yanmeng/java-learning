package com.botao.service.impl;

import com.botao.dao.ProductDao;
import com.botao.dao.impl.ProductDaoImpl;
import com.botao.pojo.Product;
import com.botao.service.ProductService;
import com.botao.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();

    /**
     * 调用方法
     * ProductServiceImpl productService = new ProductServiceImpl();
     * Product product = new Product(null,"臭干子","不辣",155.5,100,"b.jpg",null,null);
     * Boolean add = productService.add(product);
     * System.out.println(add);
     *
     * @param product 商品对象
     * @return 是否成功
     * @throws SQLException
     */
    @Override
    public Boolean add(Product product) throws SQLException {
        Connection connection = BaseDao.getConnection();
        int add = productDao.add(connection, product);
        connection.close();
        return add == 1;
    }

    @Override
    public Boolean remove(String id) throws SQLException {
        Connection connection = BaseDao.getConnection();
        int remove = productDao.remove(connection, id);
        connection.close();
        return remove == 1;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        Connection connection = BaseDao.getConnection();
        List<Product> allProducts = productDao.getAllProducts(connection);
        connection.close();
        return allProducts;
    }

    @Override
    public List<Product> getAllProductsExceptDeleted() throws SQLException {
        Connection connection = BaseDao.getConnection();
        List<Product> allProducts = productDao.getAllProductsExceptDeleted(connection);
        connection.close();
        return allProducts;
    }

    @Override
    public Product getProductById(String id) throws SQLException {
        Connection connection = BaseDao.getConnection();
        Product product = productDao.getProductById(connection, id);
        connection.close();
        return product;
    }
}
