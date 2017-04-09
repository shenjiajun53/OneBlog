package com.joni.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by shenjiajun on 2017/4/3.
 */

@Document(collection = "User")
public class User {

    @Id
    private String id;
    private String userName;
    private String pass;
    private String avatarPath;
    private String userIntro;

    public User(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
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

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getUserIntro() {
        return userIntro;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

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
}
