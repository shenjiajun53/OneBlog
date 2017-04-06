package com.joni.service;

import com.joni.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by shenjj on 2017/4/6.
 */

@Service
public class UserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoOperations mongoOperations;

    public void insertUser(User user) {
        mongoOperations.insert(user, "User");
        System.out.printf("insert user=" + user.toString());
    }

}
