package com.joni.model;

/**
 * Created by Administrator on 2017/4/11.
 */
public class BlogInfoBean {
    private Blog blog;
    private User user;

    public BlogInfoBean(Blog blog, User user) {
        this.blog = blog;
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
