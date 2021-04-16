package com.atguigu.java;

import org.junit.Test;

/**
 * 相同的内容会调用同一个值的地址，重新赋值会创建新的值并赋予新值的地址，拼接内容会使用新内存创建新值
 *
 * @author chenglongsheng
 * @create 2021-04-16 8:54
 */
public class StringTest {

    /*
    1.String声明为final，不可被继承
    2.String实现了Serializable接口：表示字符串是支持序列化的
            实现了Comparable接口：表示String可以比较大小
    3.String内部定义了final char[] value用于储存字符串数据
    4.String：代表不可变的字符序列。简称：不可变性。
        体现；1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有value进行赋值
             2.当对现有字符串进行连续操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
             3.当调用String的replace()修改指定字符或者字符串时，也需要重新指定内存区域
    5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
    6.字符串常量池时不会储存相同内容的字符串的。
     */
    @Test
    public void Test1(){

        String s1 = "abc";
        String s2 = "abc";

        String s3 = "a";
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("*************");
        String s4 = "abc";
        s4+="def";
        System.out.println(s4);

        System.out.println("*************");

        String s5 = "abc";
        String s6 = s5.replace('a', 'b');
        System.out.println(s6);
    }
}
