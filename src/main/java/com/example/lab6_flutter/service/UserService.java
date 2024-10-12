package com.example.lab6_flutter.service;

import com.example.lab6_flutter.entity.User;

public interface UserService {
    void register(User user);
    void login(User user);
}
