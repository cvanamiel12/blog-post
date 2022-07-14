package com.zuitt.wdc044.controllers;

import com.zuitt.wdc044.models.Post;
import com.zuitt.wdc044.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public ResponseEntity<Object> createPost(@RequestHeader(value = "Authorization") String stringToken, @RequestBody Post post){
        postService.createPost(stringToken, post);
        return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
    }

    //add a postcontroller method named /getPosts that will retrieve all posts from the database. This method should respond to a get request to the /posts endpoint. It should return a new response entity that calls the getPosts() method from postService.java as well as an HTTPStatus.OK.
    //no arguments will be needed to be passed to this method

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<Object> getPost() {

        //return postService.getPosts() in ResponseEntity
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }
}
