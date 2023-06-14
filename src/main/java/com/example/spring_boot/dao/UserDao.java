package com.example.spring_boot.dao;


import com.example.spring_boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(int id);

    void saveUser(User user);

    void updateUser(User updateUser);

    void deleteUserById(int id);
}