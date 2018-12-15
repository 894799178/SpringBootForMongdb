package com.test.demo.config;


import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;

public class MongoConfig {


    /**
     *  创建Mongo 连接驱动
     * @return
     */
    @Bean
    public Mongo newClient() {
        Mongo mongo = new MongoClient("localhost",27017);
        return mongo;
    }

    @Bean
    public MongoTemplate newTemplate() {
        MongoTemplate template = new MongoTemplate((MongoClient) newClient(),"SQZZ");
        return template;
    }

}
