package com.usermanagesystem.http;

import com.usermanagesystem.dao.UserDao;
import com.usermanagesystem.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DeleteUserServlet extends HttpServlet {
    public DeleteUserServlet() {
        super();
    }

    // ��ʼ������
    public void init() throws ServletException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        int userid = Integer.parseInt(request.getParameter("userId"));
        String msg = null;
        UserDao dao = new UserDaoImpl();
        int row = dao.deleteUser(userid);
        if (row >= 0)
            msg = "�û�ɾ���ɹ���";
        else
            msg = "�û�ɾ��ʧ�ܣ�";
        out.print(msg);
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    public void destroy() {
        super.destroy();
    }


}
