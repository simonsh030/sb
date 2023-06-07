package com.example.spring_boot.service;


import com.example.spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(User user);

    void updateUser(User updatedUser);

    void deleteUserById(int id);
}