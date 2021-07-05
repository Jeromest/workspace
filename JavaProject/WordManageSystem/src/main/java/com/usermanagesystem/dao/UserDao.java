package com.usermanagesystem.dao;

import com.usermanagesystem.entity.User;

import java.util.List;


// UesrDao 接口
public interface UserDao {
    // 登录方法
    public User login(String account, String password);

    public int insertUser(User u);

    public User findUserById(int userid);

    public int updateUser(User u);

    public int deleteUser(int userid);

    public List<User> userList();
}
