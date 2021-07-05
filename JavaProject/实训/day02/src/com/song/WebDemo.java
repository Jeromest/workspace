package com.song;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

public class WebDemo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username：" + username + "\t" + "password：" + password);

        try {
            //1.Class.forName()加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.DriverManager获取Connection连接
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT",
                    "root",
                    "123456");
            //4.定义sql语句
//            String sql = "select * from user where username='" + username + "' and password='" + password + "'";
            String sql = "select * from user where username=? and password=?";
            //5.获取执行sql的对象 Statement
//            Statement stmt = conn.createStatement();
            PreparedStatement pstm = conn.prepareStatement(sql);

            //给占位符赋值
            pstm.setString(1, username);
            pstm.setString(2, password);

            //6.执行sql
            ResultSet rs = pstm.executeQuery(sql);
            //7.处理结果
            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("成功", username);
                resp.sendRedirect("success.jsp");
                req.setAttribute("username", username);
                //转发
//                req.getRequestDispatcher("success.jsp").forward(req, resp);
                //重定向
//                resp.sendRedirect("success.jsp");
            } else {
                System.out.println("登录失败！");
            }
            //8.关闭连接
            pstm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
