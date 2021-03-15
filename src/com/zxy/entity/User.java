package com.zxy.entity;

import java.util.Date;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/7
 * @time: 21:03
 */
public class User {
    private int user_id;
    private String user_code;
    private String password;
    private String email;
    private String gender;
    private Date register_time;
    private Date last_logintime;

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }

    public Date getLast_logintime() {
        return last_logintime;
    }

    public void setLast_logintime(Date last_logintime) {
        this.last_logintime = last_logintime;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_code='" + user_code + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", register_time=" + register_time +
                ", last_logintime=" + last_logintime +
                '}';
    }
}
