package com.test.demo.service;

/**
 *  数据处理服务.
 */
public interface DataProcessService {

    /**
     * 过滤字符串如果存在所需要数据则,填充对象并返回.
     * @param string 按照标记字符串进行过滤字符串
     * @param flag 索要填充的类型
     * @param clazz<T> 对应需要转换的类.
     * @return
     */
    <T> T stringToDamageBean(String string,String flag,Class<T> clazz);
}
