package com.atguigu.java;

import org.junit.Test;

/**
 * @author chenglongsheng
 * @create 2021-06-15 22:05
 */
public class ReflectionTest {

    /*
    反射之前，对于Person的操作
     */
    @Test
    public void test1() {

        Person p1 = new Person("TOm",12);
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        // 在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        // 比如：name、showNation()以及私有的构造器


    }

}
