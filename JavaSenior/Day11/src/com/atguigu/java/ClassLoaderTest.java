package com.atguigu.java;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

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

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);

    }

    /*
    Properties：读取配置文件
     */
    @Test
    public void test2() throws Exception {

        Properties pros = new Properties();
        // 读取配置文件方式一：
        // 此文件路径默认在当前module下
//        FileInputStream fis = new FileInputStream("jdbc.properties");

        // 读取配置文件方式二：使用ClassLoader
        // 默认路径在src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");

//        pros.load(fis);
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ", password = " + password);

    }

}
