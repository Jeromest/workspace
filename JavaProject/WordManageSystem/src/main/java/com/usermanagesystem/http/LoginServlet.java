package com.usermanagesystem.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagesystem.dao.UserDao;
import com.usermanagesystem.dao.impl.UserDaoImpl;
import com.usermanagesystem.entity.User;


public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + ":" + password);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String msg = null;
        UserDao dao = new UserDaoImpl();
        User u = dao.login(username, password);
        if (u != null) {
            // 响应客户端内容，登录成功
            out.print(u.getId() + "," + u.getName() + "," + u.getGender() + "," + u.getFavorite());
        } else {
            out.print("0");
        }

        out.flush();
        out.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
