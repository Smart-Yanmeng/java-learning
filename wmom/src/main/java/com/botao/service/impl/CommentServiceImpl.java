package com.botao.service.impl;

import com.botao.dao.CommentDao;
import com.botao.dao.impl.CommentDaoImpl;
import com.botao.pojo.Comment;
import com.botao.service.CommentService;
import com.botao.utils.BaseDao;
import com.botao.utils.Helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao = new CommentDaoImpl();

    @Override
    public List<Comment> getCommentByProductId(String productId) throws SQLException {
        Connection connection = BaseDao.getConnection();
        List<Comment> comments = commentDao.getCommentById(connection, productId);
        connection.close();
        return comments;
    }
    @Override
    public boolean addComment(Comment comment) throws SQLException {
        comment.setId(Helper.getUUID());
        comment.setCreated(new java.sql.Date(new Date().getTime()));
        Connection connection = BaseDao.getConnection();
        int i = commentDao.addComment(connection, comment);
        connection.close();
        return i!=0;
    }

    @Override
    public int getNum(String productid) throws SQLException {
        Connection connection = BaseDao.getConnection();
        int num = commentDao.getNum(connection, productid);
        return num;
    }
}
