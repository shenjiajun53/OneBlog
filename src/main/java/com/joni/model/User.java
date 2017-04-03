package com.joni.model;

import org.springframework.data.annotation.Id;

/**
 * Created by shenjiajun on 2017/4/3.
 */
public class User {

    @Id
    public String id;
    public String userName;
    public String pass;
    public String avatarPath;


    public User(String userName) {
        this.userName = userName;
    }
}
