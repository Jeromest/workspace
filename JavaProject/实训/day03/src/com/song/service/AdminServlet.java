package com.song.service;

import com.song.dao.AdminDao;
import com.song.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;


public class AdminServlet extends HttpServlet {

    AdminDao adminDao = new AdminDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置字符编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        String msg = req.getParameter("msg");

        try {
            switch (msg) {
                case "login":
                    System.out.println("登录, login");
                    login(req, resp);
                    break;
                case "register":
                    System.out.println("注册, register");
                    register(req, resp);
                    break;
                case "change":
                    System.out.println("修改密码, change");
                    change(req, resp);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Admin admin = adminDao.login(username, password);

        if (admin != null) {
            req.setAttribute("admin", admin);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            System.out.println("登录失败failed！");
            req.setAttribute("error", "账号或密码错误！");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        String email = req.getParameter("email");
        String tel = req.getParameter("tel");

        //判断两次密码输入是否一致
//        if (password == repassword) {
            Boolean flag = adminDao.register(username, password, email, tel);

            if (flag) {
//                System.out.println("注册成功！");
                req.setAttribute("error", "注册成功，请登录！");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {
//                System.out.println("注册失败！");
                req.setAttribute("error", "注册失败！");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }
//        } else {
//            System.out.println("两次密码不一致！");
//            req.setAttribute("error", "两次密码不一致！");
//            req.getRequestDispatcher("register.jsp").forward(req, resp);
//        }

    }

    private void change(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {


        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String newpassword = req.getParameter("newpassword");
//
        Boolean flag = adminDao.change(username, newpassword);


//        Admin admin = adminDao.change(username, newpassword);
//
//        System.out.println(admin.getUsername());
//        System.out.println(admin.getPassword());


        if (flag) {
//            System.out.println("修改成功！");
            req.setAttribute("error", "修改成功，请登录！");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
//            System.out.println("修改失败！");
            req.setAttribute("error", "修改失败，请检查账号或密码！");
            req.getRequestDispatcher("changepassword.jsp").forward(req, resp);
        }

    }

}
