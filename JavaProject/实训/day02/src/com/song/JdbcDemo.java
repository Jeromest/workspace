package com.song;

import java.sql.*;
import java.util.ArrayList;

public class JdbcDemo {
    public static void main(String[] args) {
        try {
            //1.Class.forName()加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.DriverManager获取Connection连接
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT",
                    "root",
                    "123456");

            //4.定义sql语句
            String sql = "select * from user";

            //5.获取执行sql的对象 Statement
            Statement stmt = conn.createStatement();

            //6.执行sql
            ResultSet rs = stmt.executeQuery(sql);

            //7.处理结果
            while (rs.next()) {
//                System.out.println(rs.getInt("bookID"));
                System.out.println(rs.getString("username"));
            }

            //8.关闭连接
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
