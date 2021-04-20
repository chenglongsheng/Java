package com.atguigu.java;

import org.junit.Test;

/**
 * @author chenglongsheng
 * @create 2021-04-20 8:44
 */
public class IDEADebug {

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//4
        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//空指针异常
        System.out.println(sb1);
    }
}
