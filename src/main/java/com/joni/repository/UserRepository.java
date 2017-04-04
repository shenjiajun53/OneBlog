package com.joni.repository;

import com.joni.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by shenjiajun on 2017/4/3.
 */


public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByUserName(@Param("userName") String userName);

    User findById(@Param("id") String id);
}