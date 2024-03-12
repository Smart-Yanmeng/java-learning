package com.mashang.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.PrimitiveIterator;
import java.util.Properties;

public class JDBCUtils02 {

    private static String driverClassName;
    private static String url;
    private static String username;
    private static String password;

    // 静态代码块
    // 类第一次被加载时自动执行一遍
    static {
        try {
            // 类加载器
            ClassLoader loader = JDBCUtils02.class.getClassLoader();

            // 读取配置文件转化成字节输入流
            InputStream inputStream = loader.getResourceAsStream("jdbc.properties");

            // Properties 用来处理 properties 文件, 获取里面的信息
            Properties properties = new Properties();

            // 把字节输入流的信息加载到 Properties 对象
            properties.load(inputStream);

            driverClassName = properties.getProperty("jdbc.driverClassName");
            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");

            System.out.println(driverClassName);
            System.out.println(url);
            System.out.println(username);
            System.out.println(password);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        Connection conection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest?userSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
