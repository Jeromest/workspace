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
import com.usermanagesystem.dao.impl.WordDaoImpl;
import com.usermanagesystem.entity.User;
import com.usermanagesystem.entity.Word;

public class ListWordServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        List<Word> words = new WordDaoImpl().wordList();
        StringBuilder builder = new StringBuilder();
        String format = request.getParameter("format");
        if (format.equals("json")) {
            builder.append('[');
            for (Word word : words) {
                builder.append("{");
                builder.append("id:").append(word.getId()).append(',');
                builder.append("word:").append(word.getWord()).append(',');
                builder.append("detail:").append(word.getDetail());
                builder.append("},");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(']');
            out.print(builder.toString());
        } else if (format.equals("xml")) {
            builder.append("<?xml version='1.0' encoding='UTF-8'?>");
            builder.append("<wordlist>");
            for (Word word : words) {
                builder.append("<wordcontent>");
                builder.append("<id>");
                builder.append(word.getId());
                builder.append("</id>");
                builder.append("<word>");
                builder.append(word.getWord());
                builder.append("</word>");
                builder.append("<detail>");
                builder.append(word.getDetail());
                builder.append("</detail>");
                builder.append("</wordcontent>");
            }
            builder.append("</wordlist>");
            out.print(builder.toString());
        }
        System.out.println(builder.toString());
        out.flush();
        out.close();
    }


}
