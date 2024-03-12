package com.botao.service.impl;

import com.botao.dao.CartDao;
import com.botao.dao.ProductDao;
import com.botao.dao.impl.CartDaoImpl;
import com.botao.dao.impl.ProductDaoImpl;
import com.botao.pojo.Cart;
import com.botao.pojo.Product;
import com.botao.service.CartService;
import com.botao.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao cartDao = new CartDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public boolean addCat(String productId, String userId) throws SQLException {
        Connection connection = BaseDao.getConnection();
        Cart cart = cartDao.getCartByProductId(connection, productId, userId);
        System.out.println("商品是否已经在购物车了？"+(cart!=null));
        if (cart != null) {
            return false;
        }
        int i = cartDao.addCat(connection, productId, userId);
        connection.close();
        return i == 1;
    }

    @Override
    public List<Product> getCartsByUserId(String userId) throws SQLException {
        Connection connection = BaseDao.getConnection();
        List<String> productIdList = cartDao.getCartsByUserId(connection, userId);
        List<Product> products = new ArrayList<>();
        int size = productIdList.size();
        for (int i = 0; i < size; i++) {
            Product product = productDao.searchProductsById(connection, productIdList.get(i));
            products.add(product);
        }
        return products;
    }
    @Override
    public boolean deleteCartById(String productId, String userId) throws SQLException {
        Connection connection = BaseDao.getConnection();
        int i = cartDao.deleteCartById(connection, productId, userId);
        connection.close();
        return i != 0;
    }
}
