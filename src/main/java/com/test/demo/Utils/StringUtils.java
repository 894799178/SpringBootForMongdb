package com.test.demo.Utils;

public class StringUtils {


    /**
     *
     * @param str
     * @param subStr
     * @return
     */
    public static int isExist(String str,String subStr){
        int index = str.indexOf(subStr);
        return index >0 ?index+subStr.length():index;
    }


}
