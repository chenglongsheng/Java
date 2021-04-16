package com.atguigu.java;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 * @author chenglongsheng
 * @create 2021-04-16 21:14
 */
public class StringBufferBuilderTest {
    /*
    效率高低：StringBuilder>StringBuffer>String
     */

    /*
    String、StringBuffer、StringBuilder三者的异同
    String：不可变字符序列；底层使用char[]储存
    StringBuffer：可变字符序列；线程安全的，效率低；底层使用char[]储存
    StringBuilder：可变的字符序列；JDK5.0线程不安全，效率高；底层使用char[]储存

    源码分析：
    String str = new String();//char[] value = new char[0];
    String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};


    StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];//底层是创建了一个长度16的数组
    sb1.append('a');//value[0] = 'a';
    sb1.append('b');//value[1] = 'b';

    StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 1];

    System.out.println(sb2.length());//3
    扩容问题：如果要添加的数据底层数组盛不下，那就需要扩容底层的数组。
    默认情况下，扩容为原来的2倍+2，同时将原有数组中的元素赋值到新的数组中。

    开发中建议使用StringBuffer(int capacity)或 StringBuilder(int capacity)
     */

    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
    }
}
