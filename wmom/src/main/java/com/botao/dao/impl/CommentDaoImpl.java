package com.botao.dao.impl;

import com.botao.dao.CommentDao;
import com.botao.pojo.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Comment> getCommentById(Connection connection, String productid) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from comment where productid='" + productid + "' order by created desc");
        ArrayList<Comment> comments = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String productid1 = resultSet.getString("productid");
            String username = resultSet.getString("username");
            String text = resultSet.getString("text");
            Date created = resultSet.getDate("created");
            Date deleted = resultSet.getDate("deleted");
            Comment comment = new Comment(id, productid1, username, text, created, deleted);
            comments.add(comment);
        }
        return comments;
    }

    @Override
    public int addComment(Connection connection, Comment comment) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into comment value (?,?,?,?,?,?)");
        preparedStatement.setString(1, comment.getId());
        preparedStatement.setString(2, comment.getProductid());
        preparedStatement.setString(3, comment.getUsername());
        preparedStatement.setString(4, comment.getText());
        preparedStatement.setDate(5, (java.sql.Date) comment.getCreated());
        preparedStatement.setDate(6, (java.sql.Date) comment.getDeleted());
        int i = preparedStatement.executeUpdate();
        return i;
    }

    @Override
    public int getNum(Connection connection, String productid) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(*) from comment where productid ='" + productid + "'");
        int num=0;
        while (resultSet.next()){
            num = resultSet.getInt(1);
        }
        return num;
    }
}
