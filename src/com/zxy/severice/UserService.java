package com.zxy.severice;

import com.zxy.entity.User;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/7
 * @time: 21:03
 */
public interface UserService {
    public int register(User user);
    public User login(String user_id,String pass);
    public int delete(int user_id);
    public int update(int user_id);
    public boolean check_user_code(String user_code);
}
