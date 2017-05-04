package com.joni.model;

import org.springframework.data.mongodb.core.index.Indexed;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shenjj on 2017/5/2.
 */

@Entity
@Table(name = "User")
public class HibernateUser {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;


    @Indexed(unique = true, dropDups = true)
    private String userName;
    private String pass;
    private String avatarPath;
    private String userIntro;



    public HibernateUser() { }

    public HibernateUser(long id) {
        this.id = id;
    }

    public HibernateUser(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
