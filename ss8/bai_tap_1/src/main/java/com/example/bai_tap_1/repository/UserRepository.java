package com.example.bai_tap_1.repository;

import com.example.bai_tap_1.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository implements IUserRepository {
    private List<User> userList = new ArrayList<>();

    @Override
    public List<User> getList() {
        return userList;
    }

    @Override
    public void createUser(User user) {
        userList.add(user);
    }
}
