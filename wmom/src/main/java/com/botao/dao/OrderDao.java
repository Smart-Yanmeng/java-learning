package com.botao.dao;

import com.botao.pojo.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    /**
     * 获取所有的订单信息
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<Order> getAllOrders(Connection connection) throws SQLException;

    /**
     * 根据订单id查询订单信息
     * @param connection
     * @param id
     * @return
     * @throws SQLException
     */
    public Order getOrderById(Connection connection,String id) throws SQLException;


    /**
     * 根据用户id查询订单
     * @param connection
     * @param userId
     * @return
     * @throws SQLException
     */
    public List<Order> getOrdersByUserId(Connection connection,String userId) throws  SQLException;


    /**
     * 根据订单状态查询订单
     * @param connection
     * @param status
     * @return
     * @throws SQLException
     */
    public List<Order> getOrdersByStatus(Connection connection,Integer status) throws  SQLException;

    /**
     * 根据订单状态查询一个用户的订单
     * @param connection
     * @param userId
     * @param status
     * @return
     * @throws SQLException
     */
    public List<Order> getOrdersByUserIdAndStatus(Connection connection,String userId,Integer status) throws  SQLException;

    /**
     * 添加订单
     * @param connection
     * @param order
     * @return
     * @throws SQLException
     */
    public int addOrder(Connection connection,Order order) throws SQLException;

    /**
     * 更新状态
     * @param connection
     * @param id
     * @param i
     * @return
     * @throws SQLException
     */
    public int updateStatus(Connection connection,String id ,int i) throws SQLException;

    /**
     * 用户取消订单
     * @param connection
     * @param id
     * @return
     * @throws SQLException
     */
    public int deleteOrder(Connection connection, String id) throws SQLException;

    /**
     * 通过id获取销量
     * @param connection
     * @return
     * @throws SQLException
     */
    public int getNum(Connection connection, String id)throws SQLException;;

}
