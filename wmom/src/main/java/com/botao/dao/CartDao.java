package com.botao.dao;

import com.botao.pojo.Cart;
import com.botao.pojo.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    /**
     * 加入购物车
     * @param productId 商品id
     * @param userId 用户id
     * @return
     * @throws SQLException
     */
    public int addCat(Connection connection, String productId, String userId) throws SQLException;

    /**
     * 根据用户id查询他所有的加入到购物车的商品
     * @param connection
     * @param userId
     * @return
     * @throws SQLException
     */
    public List<String> getCartsByUserId(Connection connection, String userId) throws SQLException;

    /**
     * 移出购物车
     * @param connection
     * @param userId
     * @return
     * @throws SQLException
     */
    public int deleteCartById(Connection connection,String productId,String userId) throws SQLException;

    /**
     * 更具用户获取商品id
     * @param connection
     * @param productId
     * @param userId
     * @return
     * @throws SQLException
     */
    public Cart getCartByProductId(Connection connection,String productId, String userId) throws SQLException;
}
