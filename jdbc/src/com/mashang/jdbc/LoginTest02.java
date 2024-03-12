package com.mashang.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginTest02 {
    public static void main(String[] args) {

        // 封装成List
        List<Student> students = new ArrayList<>();

        Connection conection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest?userSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8", "root", "root");

            String name = "ZhangSan";
            String password = "zhangsan";

            String sql = "select * from t_student where name = ? and password = ?";
            preparedStatement = conection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("登录成功");
            } else {
                System.out.println("登陆失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (conection != null) {
                    conection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
