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
     * ͨ���û����ƺ������¼����¼�ɹ�����User���󣬵�¼ʧ�ܷ���null
     */
    public User login(String account, String password) {

        // ��ѯSQL���
        sql = " select id, account, password, name, favorite, remark from userTbl " +
                " where account=? and password=? ";

        try {
            // ���Ԥ�������
            psmt = conn.prepareStatement(sql);
            // ���ò�ѯ����
            psmt.setString(1, account);
            psmt.setString(2, password);
            // ִ�в�ѯ
            ResultSet rs = psmt.executeQuery();
            // �ж��û��Ƿ����
            if (rs.next()) {
                // ����û���Ϣ
                int id = rs.getInt(1);
                String name = rs.getString(4);
                String favorite = rs.getString(5);
                String remark = rs.getString(6);
                // ��װ�û���Ϣ
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
     * ����û�
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
            System.out.print("����û���Ϣ��");
            e.printStackTrace();
        }
        return row;
    }

    public UserDaoImpl() {
        super();
        // ���ݿ����ӹ�����
        util = new DBUtil();
        // �������
        conn = util.openConnection();
    }

    /**
     * ����id�����û�
     * @param userid
     * @return
     */
    public User findUserById(int userid) {
        // ��ѯSQL���
        sql = " select id,account,password,name,favorite,remark " +
                " from userTbl " +
                " where id=?  ";
        try {
            // ���Ԥ�������
            psmt = conn.prepareStatement(sql);
            // ���ò�ѯ����
            psmt.setInt(1, userid);
            // ִ�в�ѯ
            ResultSet rs = psmt.executeQuery();
            // �ж��û��Ƿ����
            if (rs.next()) {
                // ����û���Ϣ
                int id = rs.getInt(1);
                String account = rs.getString(2);
                String password = rs.getString(3);
                String name = rs.getString(4);
                String favorite = rs.getString(5);
                String remark = rs.getString(6);
                // ��װ�û���Ϣ
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
        // ��ѯSQL���
        sql = " delete userTbl where id=?  ";
        try {
            // ���Ԥ�������
            psmt = conn.prepareStatement(sql);
            // ���ò�ѯ����
            psmt.setInt(1, userid);
            // ִ�в�ѯ
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
            System.out.print("���޸��û���Ϣ��");
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
