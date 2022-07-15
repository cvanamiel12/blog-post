package com.zuitt.wdc044.services;

import com.zuitt.wdc044.config.JwtToken;
import com.zuitt.wdc044.models.Post;
import com.zuitt.wdc044.models.User;
import com.zuitt.wdc044.repositories.PostRepository;
import com.zuitt.wdc044.repositories.UserRepository;
import io.jsonwebtoken.Jwt;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity updatePost(Long id, String stringToken, Post post){
        Post postForUpdating = postRepository.findById(id).get();
        String postAuthor = postForUpdating.getUser().getUsername();
        String authenticatedUser = jwtToken.getUsernameFromToken((stringToken));

        if(authenticatedUser.equals(postAuthor)){
            postForUpdating.setTitle(post.getTitle());
            postForUpdating.setContent(post.getContent());
            postRepository.save(postForUpdating);
            return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You are not authorized to edit this post", HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity deletePost(Long id, String stringToken){
        Post postForUpdating = postRepository.findById(id).get();
        String postAuthor = postForUpdating.getUser().getUsername();
        String authenticatedUser = jwtToken.getUsernameFromToken(stringToken);

        if(authenticatedUser.equals(postAuthor)){
            postRepository.deleteById(id);
            return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You are not authorized to delete this post", HttpStatus.UNAUTHORIZED);
        }
    }


    public Iterable<Post> getPosts(){
        return postRepository.findAll();
    }

}
