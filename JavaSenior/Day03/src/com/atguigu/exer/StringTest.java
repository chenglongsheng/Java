package com.atguigu.exer;

/**
 * 一道面试题
 * String 不可变性
 *
 * @author chenglongsheng
 * @create 2021-04-16 10:48
 */
public class StringTest {

    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + "and");
        System.out.println(ex.ch);
    }
}
