package com.joni.repository;

import com.joni.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shenjiajun on 2017/4/3.
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByUserName(String userName);

    User findById(@Param("id") String id);
}
