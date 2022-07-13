package com.zuitt.wdc044.services;

import com.zuitt.wdc044.models.User;
import com.zuitt.wdc044.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired //injects code from classes/files that we have imported
    private UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);
    }

    public Optional<User> findByUsername(String username){
        return Optional.ofNullable(userRepository.findByUsername(username));
    }


}
