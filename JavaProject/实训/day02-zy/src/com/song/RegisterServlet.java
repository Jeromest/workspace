package com.song;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        System.out.println(username + "\t" + password + "\t" + phone);

        try {
            //1.Class.forName()加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.DriverManager获取Connection连接
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT",
                    "root",
                    "123456");
            //4.定义sql语句
            String sql = "insert into user (id, username, password, phone) " +
                    "values (null,'" + username + "', '" + password + "', '" + phone + "')";
            //5.获取执行sql的对象 Statement
            Statement stmt = conn.createStatement();
            //6.执行sql
            int count = stmt.executeUpdate(sql);
            //7.处理结果
            if (count > 0) {
                req.setAttribute("username", username);
                req.getRequestDispatcher("success.jsp").forward(req, resp);
            } else {
                System.out.println("注册失败！");
            }
            //8.关闭连接
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
