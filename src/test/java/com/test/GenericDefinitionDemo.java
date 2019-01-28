package com.test;

import org.junit.Test;

public class GenericDefinitionDemo<T> {

    static <String, T,Alibaba> String get(String string,Alibaba alibaba){
        return string;
    }


    @Test
    public void test(){
        Integer first = 222;
        Long second = 333L;
        Integer result = get(first,second);
        System.out.println(result);
    }

}
