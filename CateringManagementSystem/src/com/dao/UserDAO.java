package com.dao;

import com.entity.User;

public interface UserDAO {
    boolean haveUser(User user);
    boolean addUser(User user);
}
