package com.usermanagesystem.util;

import com.usermanagesystem.dao.impl.WordDaoImpl;
import com.usermanagesystem.entity.Word;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 *
 */
public class DBUtil {
    /**
     * 关闭数据库连接
     */
    public void closeConn(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开数据库连接
     */
    public Connection openConnection() {
        Properties prop = new Properties();
        String driver = null;
        String url = null;
        String username = null;
        String password = null;

        try {
            prop.load(this.getClass().getClassLoader().getResourceAsStream(
                    "DBConfig.properties"));

            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<Word> words = new WordDaoImpl().wordList();
        //String format=request.getParameter("format");
        //if("json".equals(format)){
        StringBuilder bulider = new StringBuilder();
        bulider.append('[');
        for (Word word : words) {
            bulider.append("{");
            bulider.append("id:").append(word.getId()).append(',');
            bulider.append("word:").append(word.getWord()).append(',');
            bulider.append("detail:").append(word.getDetail());
            bulider.append("},");
        }

        bulider.deleteCharAt(bulider.length() - 1);
        bulider.append(']');
        System.err.println(bulider.toString());
    }
}
