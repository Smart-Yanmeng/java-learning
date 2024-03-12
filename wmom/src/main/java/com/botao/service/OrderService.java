package com.botao.service;

import com.botao.pojo.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    /**
     * 订单创建
     * @param order
     * @return
     * @throws SQLException
     */
    public boolean addOrder(Order order) throws SQLException;

    /**
     * 通过用户id查询订单
     * @param userId
     * @return
     * @throws SQLException
     */
    public List<Order> getOrdersByUserId(String userId) throws SQLException;

    /**
     * 获取所有的订单
     * @return
     * @throws SQLException
     */
    public List<Order> getAllOrders() throws SQLException;

    /**
     * 根据订单id查询订单
     * @param id
     * @return
     * @throws SQLException
     */
    public Order getOrderById(String id) throws SQLException;


    /**
     * 发货===》运输
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean sendProduct(String id)throws SQLException;

    /**
     * 运输===>收货
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean getProduct(String id)throws SQLException;

    /**
     * 删除订单
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean deleteOrder(String id)throws SQLException;

}
