package com.usermanagesystem.dao;

import com.usermanagesystem.entity.User;

import java.util.List;


// UesrDao �ӿ�
public interface UserDao {
    // ��¼����
    public User login(String account, String password);

    public int insertUser(User u);

    public User findUserById(int userid);

    public int updateUser(User u);

    public int deleteUser(int userid);

    public List<User> userList();
}
