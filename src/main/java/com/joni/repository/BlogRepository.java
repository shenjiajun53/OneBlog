package com.joni.repository;

import com.joni.model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */
public interface BlogRepository extends MongoRepository<Blog, String> {

    Blog findBlogById(String id);
}
