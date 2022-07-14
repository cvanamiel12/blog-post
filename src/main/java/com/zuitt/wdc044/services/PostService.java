package com.zuitt.wdc044.services;

import com.zuitt.wdc044.models.Post;

public interface PostService {

    void createPost(String stringToken, Post post);
    Iterable<Post> getPosts();

}
