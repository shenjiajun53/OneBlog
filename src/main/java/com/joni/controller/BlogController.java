package com.joni.controller;

import com.joni.model.*;
import com.joni.service.BlogService;
import com.joni.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenjj on 2017/4/11.
 */

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/api/sendBlog", method = RequestMethod.POST)
    public Response<BlogResultBean> sendBlog(
                                             @RequestParam(value = "blogTitle") String blogTitle,
                                             @RequestParam(value = "blogContent") String blogContent) {
        Subject subject = SecurityUtils.getSubject();
        String userId = (String) subject.getPrincipal();
        Blog blog = new Blog(userId, blogTitle, blogContent, System.currentTimeMillis());
        blogService.insertBlog(blog);
        Response<BlogResultBean> response = new Response<>(new BlogResultBean(blog.getId(), "/BlogDetail"), null);
        return response;
    }


    @RequestMapping(value = "/api/getBlog", method = RequestMethod.GET)
    public Response<BlogInfoBean> sendBlog(@RequestParam(value = "blogId") String blogId) {
        Blog blog = blogService.findBlogById(blogId);
        User user = userService.findUserById(blog.getUserId());
        BlogInfoBean blogInfoBean = new BlogInfoBean(blog, user);
        Response<BlogInfoBean> response = new Response<>(blogInfoBean, null);
        return response;
    }

    @RequestMapping(value = "/api/getAllBlogs", method = RequestMethod.GET)
    public Response<List<BlogInfoBean>> getAllBlogs() {
        List<Blog> blogList = blogService.findAllBlogs();
        List<BlogInfoBean> blogInfoBeanList=new ArrayList<>();
        for (int i = 0; i < blogList.size(); i++) {
            Blog blog = blogList.get(i);
            User user = userService.findUserById(blog.getUserId());
            BlogInfoBean blogInfoBean = new BlogInfoBean(blog, user);
            blogInfoBeanList.add(blogInfoBean);
        }
        Response<List<BlogInfoBean>> response = new Response<>(blogInfoBeanList, null);
        return response;
    }
}
