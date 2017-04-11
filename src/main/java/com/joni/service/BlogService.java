package com.joni.service;

import com.joni.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

/**
 * Created by shenjj on 2017/4/11.
 */

@Service
public class BlogService {

    @Autowired
    private MongoOperations mongoOperations;

    public void insertBlog(Blog blog){
        mongoOperations.insert(blog);
    }
}
