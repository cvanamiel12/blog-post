package com.zuitt.wdc044.services;

import com.zuitt.wdc044.config.JwtToken;
import com.zuitt.wdc044.models.Post;
import com.zuitt.wdc044.models.User;
import com.zuitt.wdc044.repositories.PostRepository;
import com.zuitt.wdc044.repositories.UserRepository;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    JwtToken jwtToken;

    public void createPost(String stringToken, Post post){
        //find the currently authenticated user's details
        User author = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));

        Post newPost = new Post();

        newPost.setTitle(post.getTitle());
        newPost.setContent(post.getContent());
        newPost.setUser(author);
        postRepository.save(newPost);


    }

    public Iterable<Post> getPosts(){
        return postRepository.findAll();
    }

}
