package com.botao.service;

import com.botao.pojo.Comment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CommentService {

    public List<Comment> getCommentByProductId(String productId) throws SQLException;

    public boolean addComment(Comment comment) throws SQLException;

    public int getNum(String productid) throws SQLException;
}
