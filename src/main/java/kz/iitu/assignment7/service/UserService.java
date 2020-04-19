package kz.iitu.assignment7.service;

import kz.iitu.assignment7.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findByUsername(String username);
    void createUser(User user);
}
