package com.joni.controller;

import com.joni.model.Blog;
import com.joni.model.BlogResponse;
import com.joni.model.Response;
import com.joni.model.User;
import com.joni.service.BlogService;
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

    @RequestMapping(value = "/api/sendBlog", method = RequestMethod.POST)
    public Response<BlogResponse> sendBlog(@AuthenticationPrincipal User user, @RequestParam(value = "blogTitle") String blogTitle,
                                     @RequestParam(value = "blogContent") String blogContent
    ) {
        Blog blog = new Blog(user.getId(), blogTitle, blogContent, System.currentTimeMillis());
        blogService.insertBlog(blog);
        Response<BlogResponse> response = new Response<>(new BlogResponse(blog.getId(), "/BlogDetail"), null);
        return response;
    }
}
