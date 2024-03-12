package com.mashang.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginTest01 {
    public static void main(String[] args) {

        // 封装成List
        List<Student> students = new ArrayList<>();

        Connection conection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest?userSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8", "root", "root");

            statement = conection.createStatement();

            String name = "ZhangSan";
            String password = "zhangsan";

            resultSet = statement.executeQuery("select * from t_student where name = '" + name + "' and password = '" + password + "'");
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
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
