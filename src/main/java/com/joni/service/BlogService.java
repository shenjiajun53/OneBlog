package com.joni.service;

import com.joni.model.Blog;
import com.joni.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shenjj on 2017/4/11.
 */

@Service
public class BlogService {

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private BlogRepository blogRepository;

    public void insertBlog(Blog blog) {
        mongoOperations.insert(blog);
    }

    public Blog findBlogById(String id) {
        return blogRepository.findBlogById(id);
    }

    public List<Blog> findAllBlogs() {
        return mongoOperations.findAll(Blog.class);
    }
}
