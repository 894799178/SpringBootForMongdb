package com.test.demo.config;


import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoConfig {

    Mongo mongo = null;
    /**
     *  创建Mongo 连接驱动
     * @return
     */
//    @Bean
    public Mongo newClient() {
         mongo = new MongoClient("192.168.5.189",27017);
        return mongo;
    }

//    @Bean
    public MongoTemplate newTemplate() {
        MongoTemplate template = new MongoTemplate((MongoClient) mongo,"SQZZ");
        return template;
    }

}
