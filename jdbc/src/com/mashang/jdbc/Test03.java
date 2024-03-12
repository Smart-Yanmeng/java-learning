package com.mashang.jdbc;

import com.mashang.utils.JDBCUtils01;
import com.mashang.utils.JDBCUtils02;

import java.sql.*;

public class Test03 {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils02.getConnection();

            preparedStatement = connection.prepareStatement("select * from t_student");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils02.close(connection, preparedStatement, resultSet);
        }

    }

}
