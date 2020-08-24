package com.sy.dao;

import com.sy.model.User;

public interface UserDao {

    User selectByUsername(String username);
    int insert(User user);
    User selectById(int id);

}
