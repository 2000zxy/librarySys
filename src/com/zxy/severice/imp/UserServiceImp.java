package com.zxy.severice.imp;

import com.zxy.dao.UserDao;
import com.zxy.dao.imp.UserDaoImp;
import com.zxy.entity.User;
import com.zxy.severice.UserService;

/**
 * @Company: 宝鸡大学
 * @author: 大宝
 * @date: 2021/3/8
 * @time: 12:57
 */
public class UserServiceImp implements UserService {
    private UserDao userDao = new UserDaoImp();
    @Override
    public int register(User user) {
        int insert = userDao.insert(user);
        return insert;
    }

    @Override
    public User login(String user_code, String pass) {
        User user = userDao.queryOne(user_code, pass);
        return user;
    }

    @Override
    public int delete(int user_id) {
        return 0;
    }

    @Override
    public int update(int user_id) {
        return 0;
    }

    @Override
    public boolean check_user_code(String user_code) {
        Boolean aBoolean = userDao.selectByUser_code(user_code);
        return aBoolean;
    }
}
