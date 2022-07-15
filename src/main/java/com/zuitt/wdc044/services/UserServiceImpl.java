package com.zuitt.wdc044.services;

import com.zuitt.wdc044.config.JwtToken;
import com.zuitt.wdc044.models.Post;
import com.zuitt.wdc044.models.User;
import com.zuitt.wdc044.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired //injects code from classes/files that we have imported
    private UserRepository userRepository;
    @Autowired
    JwtToken jwtToken;

    public void createUser(User user){
        userRepository.save(user);
    }

    public Optional<User> findByUsername(String username){
        return Optional.ofNullable(userRepository.findByUsername(username));
    }


    public ResponseEntity updateUser(Long id, String stringToken, User user){
        User userForUpdating = userRepository.findById(id).get();
        String username = userForUpdating.getUsername();
        String authenticatedUser = jwtToken.getUsernameFromToken(stringToken);
        String userPassword = user.getPassword();
        String encodedPassword = new BCryptPasswordEncoder().encode(userPassword);

        if (authenticatedUser.equals((username))) {
            userForUpdating.setUsername(user.getUsername());
            userForUpdating.setPassword(encodedPassword);
            userRepository.save(userForUpdating);
            return  new ResponseEntity<>("Username and Password are updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You are not authorized to modify this user", HttpStatus.UNAUTHORIZED);
        }
    }


    public ResponseEntity deleteUser(Long id, String stringToken) {
        User userForUpdating = userRepository.findById(id).get();
        String username = userForUpdating.getUsername();
        String authenticatedUser = jwtToken.getUsernameFromToken(stringToken);

        if (authenticatedUser.equals((username))) {
            userRepository.deleteById(id);
            return new ResponseEntity<>("The user is deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You are not authorized to delete this user!", HttpStatus.UNAUTHORIZED);
        }
    }

}
