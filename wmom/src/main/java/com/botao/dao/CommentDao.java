package com.botao.dao;

import com.botao.pojo.Comment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CommentDao {


    /**
     * 获取
     * @param connection
     * @param productid
     * @return
     * @throws SQLException
     */
    public List<Comment> getCommentById(Connection connection, String productid) throws SQLException;

    /**
     * 添加
     * @param connection
     * @param comment
     * @return
     * @throws SQLException
     */
    public int addComment(Connection connection, Comment comment) throws SQLException;

    public int getNum(Connection connection, String productid) throws SQLException;
}
