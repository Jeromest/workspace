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


public class FindUserinfoServlet extends HttpServlet {
    public FindUserinfoServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userid = Integer.parseInt(request.getParameter("userId"));
        //System.out.println(userid);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        UserDao dao = new UserDaoImpl();
        User u = dao.findUserById(userid);
        out.print(u.getAccount() + "," + u.getPassword() + "," + u.getName() + "," + u.getFavorite());
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    // 初始化方法
    public void init() throws ServletException {
    }

}
