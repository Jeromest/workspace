package com.usermanagesystem.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagesystem.dao.UserDao;
import com.usermanagesystem.dao.impl.UserDaoImpl;
import com.usermanagesystem.entity.User;

public class ListUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        List<User> users = new UserDaoImpl().userList();
        StringBuilder builder = new StringBuilder();
        String format = request.getParameter("format");
        if (format.equals("json")) {
            builder.append('[');
            for (User user : users) {
                builder.append("{");
                builder.append("id:").append(user.getId()).append(',');
                builder.append("account:").append(user.getAccount()).append(',');
                builder.append("password:").append(user.getPassword()).append(',');
                builder.append("name:").append(user.getName()).append(',');
                builder.append("gender:").append(user.getGender()).append(',');
                builder.append("favorite:").append(user.getFavorite()).append(',');
                builder.append("remark:").append(user.getRemark());
                builder.append("},");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(']');
            out.print(builder.toString());
        } else if (format.equals("xml")) {
            builder.append("<?xml version='1.0' encoding='UTF-8'?>");
            builder.append("<users>");
            for (User user : users) {
                builder.append("<user>");
                builder.append("<id>");
                builder.append(user.getId());
                builder.append("</id>");
                builder.append("<account>");
                builder.append(user.getAccount());
                builder.append("</account>");
                builder.append("<password>");
                builder.append(user.getPassword());
                builder.append("</password>");
                builder.append("<name>");
                builder.append(user.getName());
                builder.append("</name>");
                builder.append("<gender>");
                builder.append(user.getGender());
                builder.append("</gender>");
                builder.append("<favorite>");
                builder.append(user.getFavorite());
                builder.append("</favorite>");
                builder.append("<remark>");
                builder.append(user.getRemark());
                builder.append("</remark>");
                builder.append("</user>");
            }
            builder.append("</users>");
            out.print(builder.toString());
        }
        System.out.println(builder.toString());
        out.flush();
        out.close();
    }


}
