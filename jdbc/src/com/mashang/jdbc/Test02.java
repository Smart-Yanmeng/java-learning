package com.mashang.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        // 封装成List
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet resultSet = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest?userSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8", "root", "root");

            // 开启事务, 即关闭自动提交
            connection.setAutoCommit(false);

            String sql1 = "UPDATE t_student set money = money - 500 where id = 1";
            preparedStatement1 = connection.prepareStatement(sql1);

            String sql2 = "UPDATE t_student set money = money + 500 where id = 2";
            preparedStatement2 = connection.prepareStatement(sql2);

            int result1 = preparedStatement1.executeUpdate();
            int result2 = preparedStatement2.executeUpdate();

            connection.commit();

            if (result1 > 0 && result2 > 0) {
                System.out.println("操作成功");
            }

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement1 != null) {
                    preparedStatement1.close();
                }
                if (preparedStatement2 != null) {
                    preparedStatement2.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
