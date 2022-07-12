package com.zuitt.wdc044.repositories;

import com.zuitt.wdc044.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository  // A repository contains methods for database manipulation, which it has inherited from the CrudRepository's pre-defined methods
public interface PostRepository extends CrudRepository<Post, Object> {

}
