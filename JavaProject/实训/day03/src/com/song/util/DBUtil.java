package com.song.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 */
public class DBUtil {

    /**
     * JDBC 驱动名
     */
    private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * 数据库 URL
     */
    private String DB_URL = "jdbc:mysql://localhost:3306/admin?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT";

    /**
     * 数据库用户名
     */
    private String USER = "root";

    /**
     * 数据库密码
     */
    private String PASS = "123456";

    /**
     * 连接数据库函数
     */
    public Connection getConnection() {
        Connection con = null;
        try {
            //注册JDBC驱动(加载驱动程序)
            Class.forName(JDBC_DRIVER);
            //连接数据库
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭数据库连接函数
     */
    public void closeConnection(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }
}
