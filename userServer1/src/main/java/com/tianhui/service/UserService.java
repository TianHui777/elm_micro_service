package com.tianhui.service;


import com.tianhui.po.User;

public interface UserService {
    public User getUserByIdByPass(User user);

    public User getUserById(String userId);

    public int saveUser(User user);
}