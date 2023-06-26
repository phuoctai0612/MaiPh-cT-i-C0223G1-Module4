package com.example.bai_tap_1.repository;

import com.example.bai_tap_1.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> getList();
    void createUser(User user);
}
