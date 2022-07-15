package com.zuitt.wdc044.services;

import com.zuitt.wdc044.models.Post;
import com.zuitt.wdc044.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);

    Optional<User> findByUsername (String username);


    ResponseEntity deleteUser(Long id, String stringToken);

    ResponseEntity updateUser(Long id, String stringToken, User user);



}
