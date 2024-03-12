package com.mashang.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test01 {

    public static void main(String[] args) {

        // 封装成List
        List<Student> students = new ArrayList<>();

        Connection conection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 获取数据库连接
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest?userSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8", "root", "root");

            // 获取用来操作 sql 语句的对象 Statement
            statement = conection.createStatement();

            // 执行 sql 语句, 获得一个 ResultSet 对象, 查询结果就在这个对象里面
            resultSet = statement.executeQuery("select * from t_student");

            // 从 ResultSet 对象里面获取数据
            while (resultSet.next()) {

                Integer id = resultSet.getInt("id");
                System.out.println(id);

                String name = resultSet.getString("name");
                System.out.println(name);

                String sex = resultSet.getString("sex");
                System.out.println(sex);

                String email = resultSet.getString("email");
                System.out.println(email);

                Integer class_id = resultSet.getInt("classes_id");
                System.out.println(class_id);

                System.out.println(students);

                for (Student student:students) {
                    System.out.println(student);
                }

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
