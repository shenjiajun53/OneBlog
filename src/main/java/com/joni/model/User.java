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
    public String userIntro;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                ", avatarPath='" + avatarPath + '\'' +
                ", userIntro='" + userIntro + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    public User(String userName, String pass, String avatarPath, String userIntro) {
        this.userName = userName;
        this.pass = pass;
        this.avatarPath = avatarPath;
        this.userIntro = userIntro;
    }


    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }
}
