package com.usermanagesystem.entity;

/**
 *
 */
public class User {
    // 编号
    private int id;
    // 账号
    private String account;
    // 密码
    private String password;
    // 用户名称
    private String name;
    // 性别
    private String gender;
    // 权限
    private String favorite;
    // 备注
    private String remark;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", favorite='" + favorite + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
