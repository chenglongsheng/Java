package com.atguigu.java;

import org.junit.Test;

/**
 * @author chenglongsheng
 * @create 2021-06-23 16:21
 */
public class ClassLoaderTest {
    /*
    对于自定义类，使用系统类加载器进行加载
    调用系统类加载器的getParent()：获取扩展类加载器
    调用扩展类加载器的getParent()：无法获取引导类加载器
    引导类加载器主要负责Java的核心类库，无法加载自定义类
     */
    @Test
    public void test1() {

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

    }
}
