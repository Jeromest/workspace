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

public class InsertUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String gender = new String(request.getParameter("gender").getBytes("iso-8859-1"), "utf-8");
        //String question = new String(request.getParameter("question").getBytes("iso-8859-1"),"utf-8");
        String favorite = new String(request.getParameter("favorite").getBytes("iso-8859-1"), "utf-8");
        System.out.println(account + ":" + password + ":" + name + ":" + gender + ":" + favorite);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        System.out.println("添加用户信息：");
        String msg = null;
        UserDao dao = new UserDaoImpl();
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setName(name);
        user.setGender(gender);
        user.setFavorite(favorite);

        int i = dao.insertUser(user);
        if (i >= 0)
            msg = "用户添加成功！";
        else
            msg = "用户添加不成功！";
        out.print(msg);
        System.out.print(msg);
        out.flush();
        out.close();


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
