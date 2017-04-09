package com.joni.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ResourceBundle;

/**
 * Created by shenjiajun on 2017/4/3.
 */

@Configuration
@EnableMongoRepositories(basePackages = "com.joni")
public class MongoConfig extends AbstractMongoConfiguration {


    @Override
    protected String getDatabaseName() {
        return "OneBlog";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }


//    @Bean
//    public MongoClientFactoryBean mongo() {
//        MongoClientFactoryBean factoryBean = new MongoClientFactoryBean();
//        factoryBean.setHost("localhost"); // 数据库地址
//        factoryBean.setPort(27017); // 端口
//        return factoryBean;
//    }

//    @Bean
//    public MongoOperations mongoTemplate(Mongo mongo) {
//        // 操作Mongo的模板类，提供了非常纯粹的oo操作数据库的api
//        return new MongoTemplate(mongo, "oneblog"); // dbtest 为数据库名
//    }
}
