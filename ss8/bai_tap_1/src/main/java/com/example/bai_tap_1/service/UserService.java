package com.example.bai_tap_1.service;

import com.example.bai_tap_1.model.User;
import com.example.bai_tap_1.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> getList() {
        return iUserRepository.getList();
    }

    @Override
    public void createUser(User user) {
        iUserRepository.createUser(user);
    }
}
