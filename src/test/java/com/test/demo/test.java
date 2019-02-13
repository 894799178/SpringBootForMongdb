package com.test.demo;

import com.test.demo.utils.StringUtils;
import org.junit.Test;

/**
 * @ProjectName: SpringBootForMongdb
 * @Package: com.test.demo
 * @ClassName: test
 * @Author: 一条小咸鱼
 * @Description: ${description}
 * @Date: 2019/1/30 16:41
 * @Version: 1.0
 */

public class test {


    @Test
    public void test(){
        String str = "aaaa";
        System.out.println(StringUtils.isExist(str,"1"));
    }

}
