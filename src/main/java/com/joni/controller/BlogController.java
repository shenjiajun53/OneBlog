package com.joni.controller;

import com.joni.model.*;
import com.joni.service.BlogService;
import com.joni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    public Response<BlogResponse> sendBlog(@AuthenticationPrincipal User user,
                                           @RequestParam(value = "blogTitle") String blogTitle,
                                           @RequestParam(value = "blogContent") String blogContent) {
        Blog blog = new Blog(user.getId(), blogTitle, blogContent, System.currentTimeMillis());
        blogService.insertBlog(blog);
        Response<BlogResponse> response = new Response<>(new BlogResponse(blog.getId(), "/BlogDetail"), null);
        return response;
    }


    @RequestMapping(value = "/api/getBlog", method = RequestMethod.GET)
    public Response<BlogDetailResponse> sendBlog(@RequestParam(value = "blogId") String blogId) {
        Blog blog = blogService.findBlogById(blogId);
        User user = userService.findUserById(blog.getUserId());
        BlogDetailResponse blogDetailResponse = new BlogDetailResponse(blog, user);
        Response<BlogDetailResponse> response = new Response<>(blogDetailResponse, null);
        return response;
    }
}
