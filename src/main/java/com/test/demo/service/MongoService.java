package com.test.demo.service;

public interface MongoService {

    /**
     * 删除MongoDB中的所有该Id的数据
     * @param id
     */
    void deleteById(String id);
}
