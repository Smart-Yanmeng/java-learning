package com.botao.dao;

import com.botao.pojo.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    /**
     * 添加商品
     * @param connection 链接对象
     * @param product 商品对象
     * @return 返回受影响的行数
     */
    public int add(Connection connection,Product product) throws SQLException;

    /**
     * 下架商品
     * @param connection 链接对象
     * @param id 商品对象
     * @return 返回受影响的行数
     */
    public int remove(Connection connection,String id) throws SQLException;

    /**
     *
     * @param connection 链接对象
     * @param id 商品对象
     * @return 返回受影响的行数
     */
    public Product getProductById(Connection connection,String id) throws SQLException;

    /**
     *
     * @param connection 链接对象
     * @return 商品列表
     */
    public List<Product> getAllProducts(Connection connection) throws SQLException;

    /**
     * 查询除了下架的所有商品
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<Product> getAllProductsExceptDeleted (Connection connection) throws SQLException;

    /**
     * 查找商品
     * @param connection
     * @param keyWords
     * @return
     * @throws SQLException
     */
    public List<Product> searchProducts(Connection connection,String keyWords) throws SQLException;

    /**
     * 通过id查找商品
     * @param connection
     * @param id
     * @return
     * @throws SQLException
     */
    public Product searchProductsById(Connection connection,String id) throws SQLException;



    /**
     * 根据id修改商品
     * @param connection
     * @param product
     * @return
     * @throws SQLException
     */
    public int updateProductById(Connection connection,Product product) throws SQLException;

    /**
     *
     * @param connection
     * @param id
     * @param num
     * @return
     * @throws SQLException
     */
    public int reducedById(Connection connection,String id,int num) throws SQLException;

}
