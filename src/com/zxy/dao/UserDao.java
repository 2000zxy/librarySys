package com.zxy.dao;

import com.zxy.entity.User;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/7
 * @time: 21:01
 */
public interface UserDao {
    public int insert(User user);
    public int update(User user);
    public int del(int user_id);
    public User queryOne(String user_code,String pass);
    public Boolean selectByUser_code(String user_code);
}
