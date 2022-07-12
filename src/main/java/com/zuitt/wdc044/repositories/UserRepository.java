package com.zuitt.wdc044.repositories;

import com.zuitt.wdc044.models.Post;
import com.zuitt.wdc044.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Object> {

}
