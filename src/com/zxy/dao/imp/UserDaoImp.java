package com.zxy.dao.imp;

import com.zxy.dao.UserDao;
import com.zxy.entity.User;
import com.zxy.util.BaseDao;

import java.util.List;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/7
 * @time: 21:02
 */
public class UserDaoImp extends BaseDao implements UserDao {
    @Override
    public int insert(User user) {
        String sql  = "insert into users values(null,?,?,?,?,now(),now())";
        Object[] params={user.getUser_code(),user.getPassword(),user.getEmail(),user.getGender()};
        int update = update(sql, params);
        return update;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int del(int user_id) {
        return 0;
    }


    @Override
    public User queryOne(String user_code, String pass) {
        List<User> query = query(User.class, "select * from users where user_code=? and password=?", user_code, pass);
        for (User user : query) {
            if(user!=null){
                return user;
            }
        }
        return null;
    }

    @Override
    public Boolean selectByUser_code(String user_code) {
        System.out.println(user_code);
        List<User> query = query(User.class, "select * from users where user_code=?", user_code);
        for (User user : query) {
            if(user!=null){
                System.out.println(user);
                return true;
            }
        }
        return false;
    }
}
