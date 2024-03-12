package com.botao.service;

import com.botao.pojo.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    /**
     * 添加商品
     * @param product 商品对象
     * @return 返回受影响的行数
     */
    public Boolean add(Product product) throws SQLException;

    /**
     * 下架商品
     * @param id
     * @return boolean
     * @throws SQLException
     */
    public Boolean remove(String id) throws SQLException;

    /**
     * 获取所有的商品信息
     * @return
     * @throws SQLException
     */
    public List<Product> getAllProducts() throws SQLException;

    /**
     * 获取除了被下架的所有的商品信息
     * @return
     * @throws SQLException
     */
    public List<Product> getAllProductsExceptDeleted() throws SQLException;

    /**
     * 获取指定id的商品信息
     * @param id
     * @return
     * @throws SQLException
     */
    public Product getProductById(String id) throws SQLException;

    /**
     * 查询商品
     * @param keyWords
     * @return
     * @throws SQLException
     */
    public List<Product> searchProducts(String keyWords) throws SQLException;

    /**
     * 根据id修改商品
     * @param product
     * @return
     * @throws SQLException
     */
    public boolean updateProductById(Product product) throws SQLException;

}
