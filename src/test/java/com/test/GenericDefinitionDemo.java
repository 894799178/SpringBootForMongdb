package com.test;

import org.junit.Test;

public class GenericDefinitionDemo<T> {

    static <String, T,Alibaba> String get(String string,Alibaba alibaba){
        return string;
    }


    @Test
    public void test(){

        System.out.println((String) this.dataSorting("23"));
    }
    public<T> T dataSorting(String str){

        String str1 = "321";
        return (T) str1;

    }
}
