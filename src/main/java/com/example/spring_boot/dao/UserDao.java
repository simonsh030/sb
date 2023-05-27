package com.example.spring_boot.dao;


import com.example.spring_boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();

    User show(int id);

    void save(User user);

    void update(User updateUser);

    void deleteById(int id);
}