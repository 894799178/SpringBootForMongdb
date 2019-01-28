package com.test.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.test.demo.service.DataProcessService;
import com.test.demo.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 数据处理的服务层的实现
 * @author Tester
 */
@Service
public class DataProcessServiceImpl implements DataProcessService {
    @Override
    public <T> T stringToDamageBean(String string, String flag, Class<T> clazz) {
        int exist = StringUtils.isExist(string, flag);
        T damageBean = null;
        //如果存在标记的数据
        if(exist> 0){
            int index = string.indexOf("\"");
            //String   substring = string.substring(0,string.length()-1).replace("\\","");
            String  substring = string.substring(index+1,string.length()-1).replace("\\","");
            damageBean = JSON.parseObject(substring,clazz);
        }
        return damageBean;
    }
}
