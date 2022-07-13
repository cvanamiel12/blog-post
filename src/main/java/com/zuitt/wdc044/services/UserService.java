package com.zuitt.wdc044.services;

import com.zuitt.wdc044.models.User;

import java.util.Optional;

public interface UserService {
    void createUser(User user);

    Optional<User> findByUsername (String username);
}
