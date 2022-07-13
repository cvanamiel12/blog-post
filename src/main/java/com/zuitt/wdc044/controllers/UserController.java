package com.zuitt.wdc044.controllers;

import com.zuitt.wdc044.exceptions.UserException;
import com.zuitt.wdc044.models.User;
import com.zuitt.wdc044.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody Map<String, String> body) throws UserException {
        String username = body.get("username");

        if(!userService.findByUsername(username).isEmpty()){
            throw new UserException("Username already exists");
        } else {
            String password = body.get("password");
            String encodedPassword = new BCryptPasswordEncoder().encode(password);

            User newUser = new User(username, encodedPassword);

            userService.createUser(newUser);

            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        }


    }


}
