package com.sy.dao.Impl;

import com.sy.dao.UserDao;
import com.sy.model.User;
import com.sy.util.DBUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User selectByUsername(String username) {
        String sql = "select * from user where username = ?";
        List<User> list = DBUtil.executeQuery(sql, User.class, username);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public int insert(User user) {
        String sql = "insert into user (username,password) values (?,?)";
        int i = DBUtil.executeUpdate(sql, new Object[]{user.getUsername(), user.getPassword()});
        return i;
    }

    @Override
    public User selectById(int id) {
        String sql = "select * from user where id = ?";
        List<User> list = DBUtil.executeQuery(sql, User.class, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}
