package com.example.bai_tap_1.service;

import com.example.bai_tap_1.model.User;

import java.util.List;

public interface IUserService {
    List<User> getList();
    void createUser(User user);
}
