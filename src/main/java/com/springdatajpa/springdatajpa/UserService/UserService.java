package com.springdatajpa.springdatajpa.UserService;

import com.springdatajpa.springdatajpa.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void createUser(User user);
}
