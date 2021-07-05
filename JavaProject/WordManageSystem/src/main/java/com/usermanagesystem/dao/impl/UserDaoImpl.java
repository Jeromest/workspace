package com.usermanagesystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usermanagesystem.dao.UserDao;
import com.usermanagesystem.entity.User;
import com.usermanagesystem.util.DBUtil;

/**
 *
 */
public class UserDaoImpl implements UserDao {
    private String sql;
    PreparedStatement psmt;
    DBUtil util;
    Connection conn;

    /**
     * 通过用户名称和密码登录，登录成功返回User对象，登录失败返回null
     */
    public User login(String account, String password) {

        // 查询SQL语句
        sql = " select id, account, password, name, favorite, remark from userTbl " +
                " where account=? and password=? ";

        try {
            // 获得预定义语句
            psmt = conn.prepareStatement(sql);
            // 设置查询参数
            psmt.setString(1, account);
            psmt.setString(2, password);
            // 执行查询
            ResultSet rs = psmt.executeQuery();
            // 判断用户是否存在
            if (rs.next()) {
                // 获得用户信息
                int id = rs.getInt(1);
                String name = rs.getString(4);
                String favorite = rs.getString(5);
                String remark = rs.getString(6);
                // 封装用户信息
                User u = new User();

                u.setId(id);
                u.setAccount(account);
                u.setPassword(password);
                u.setName(name);
                u.setFavorite(favorite);
                u.setRemark(remark);

                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加用户
     * @param u
     * @return
     */
    public int insertUser(User u) {
        int row = 0;
        sql = "insert into userTbl(account,password,name,gender,favorite) values(?,?,?,?,?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, u.getAccount());
            psmt.setString(2, u.getPassword());
            psmt.setString(3, u.getName());
            psmt.setString(4, u.getGender());
            psmt.setString(5, u.getFavorite());
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.print("添加用户信息：");
            e.printStackTrace();
        }
        return row;
    }

    public UserDaoImpl() {
        super();
        // 数据库连接工具类
        util = new DBUtil();
        // 获得连接
        conn = util.openConnection();
    }

    /**
     * 根据id查找用户
     * @param userid
     * @return
     */
    public User findUserById(int userid) {
        // 查询SQL语句
        sql = " select id,account,password,name,favorite,remark " +
                " from userTbl " +
                " where id=?  ";
        try {
            // 获得预定义语句
            psmt = conn.prepareStatement(sql);
            // 设置查询参数
            psmt.setInt(1, userid);
            // 执行查询
            ResultSet rs = psmt.executeQuery();
            // 判断用户是否存在
            if (rs.next()) {
                // 获得用户信息
                int id = rs.getInt(1);
                String account = rs.getString(2);
                String password = rs.getString(3);
                String name = rs.getString(4);
                String favorite = rs.getString(5);
                String remark = rs.getString(6);
                // 封装用户信息
                User u = new User();
                u.setId(id);
                u.setAccount(account);
                u.setPassword(password);
                u.setName(name);
                u.setFavorite(favorite);
                u.setRemark(remark);
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int deleteUser(int userid) {
        int row = 0;
        // 查询SQL语句
        sql = " delete userTbl where id=?  ";
        try {
            // 获得预定义语句
            psmt = conn.prepareStatement(sql);
            // 设置查询参数
            psmt.setInt(1, userid);
            // 执行查询
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    public int updateUser(User u) {
        int row = 0;
        sql = "update userTbl set account=?,password=?,name=?,gender=?,favorite=? where id=?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, u.getAccount());
            psmt.setString(2, u.getPassword());
            psmt.setString(3, u.getName());
            psmt.setString(4, u.getGender());
            psmt.setString(5, u.getFavorite());
            psmt.setInt(6, u.getId());
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.print("添修改用户信息：");
            e.printStackTrace();
        }
        return row;
    }

    public List<User> userList() {
        List<User> users = new ArrayList<User>();
        sql = "select id,account,password,name,gender,favorite,remark " +
                " from userTbl ";
        try {
            psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setAccount(rs.getString("account"));
                u.setGender(rs.getString("gender"));
                u.setPassword(rs.getString("password"));
                u.setName(rs.getString("name"));
                u.setFavorite(rs.getString("favorite"));
                u.setRemark(rs.getString("remark"));
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
