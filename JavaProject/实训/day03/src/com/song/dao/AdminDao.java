package com.song.dao;

import com.song.model.Admin;
import com.song.util.DBUtil;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {

    DBUtil dbUtil = new DBUtil();

    /**
     * 登录功能
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public Admin login(String username, String password) throws SQLException {

        Admin admin = null;

        Connection conn = dbUtil.getConnection();

        String sql = "select * from admin where username=? and password=?";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, username);
        pstm.setString(2, password);

        pstm.execute();
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {

            admin = new Admin();
            admin.setUsername(rs.getString("username"));
            admin.setPassword(rs.getString("password"));
            admin.setEmail(rs.getString("email"));
            admin.setTel(rs.getString("tel"));

        }
        return admin;
    }


    /**
     * 注册功能
     *
     * @param username
     * @param password
     * @param email
     * @param tel
     * @return
     * @throws SQLException
     */
    public Boolean register(String username, String password, String email, String tel) throws SQLException {

        Connection conn = dbUtil.getConnection();

        String sql = "insert into admin(username, password, email, tel) values (?, ?, ?, ?)";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, username);
        pstm.setString(2, password);
        pstm.setString(3, email);
        pstm.setString(4, tel);

        int count = pstm.executeUpdate();

        if (count > 0) {
            return true;
        }
        return false;
    }

    /**
     * 更改密码
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public Boolean change(String username, String password) throws SQLException {

        Connection conn = dbUtil.getConnection();

        String sql = "update admin set password=? where username=?";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, password);
        pstm.setString(2, username);

        int count = pstm.executeUpdate();

        if (count > 0) {
//            admin = new Admin();
//            admin.setUsername(rs.getString("username"));
//            admin.setPassword(rs.getString("password"));
//            admin.setEmail(rs.getString("email"));
//            admin.setTel(rs.getString("tel"));
            return true;
        }
        return false;
    }

}
