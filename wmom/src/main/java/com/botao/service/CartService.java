package com.botao.service;

import com.botao.pojo.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CartService {
    /**
     * 加入购物车
     * @param productId 商品id
     * @param userId 用户id
     * @return
     * @throws SQLException
     */
    public boolean addCat(String productId, String userId) throws SQLException;

    /**
     * 通过用户id获取购物车列表
     * @param userId
     * @return
     * @throws SQLException
     */
    public List<Product> getCartsByUserId(String userId) throws SQLException;

    /**
     * 在购物车通过id移出当前商品
     * @param productId
     * @param userId
     * @return
     * @throws SQLException
     */
    public boolean deleteCartById(String productId, String userId) throws SQLException;
}
