package com.joni.model;

/**
 * Created by shenjj on 2017/4/11.
 */
public class BlogResponse {
    String blogId;
    String redirect;

    public BlogResponse(String blogId, String redirect) {
        this.blogId = blogId;
        this.redirect = redirect;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
}
