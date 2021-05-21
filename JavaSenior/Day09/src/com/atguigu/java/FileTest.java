package com.atguigu.java;

import org.junit.Test;

import java.io.File;

/**
 * File类的使用
 *  1.File类的一个对象，代表一个文件或一个文件目录（文件夹）
 *  2.File类声明在Java.io包下
 *
 * @author chenglongsheng
 * @create 2021-05-21 8:40
 */
public class FileTest {
    /*
    1.创建File类的实例
        File(String filePath)
        File(String parentPath, String childPath)
        File(file parentFile, String childPath)
    2.
        相对路径：相较于某个路径下，指明的路径
        绝对路径：包含盘符在内的文件或者文件目录的路径
     */
    @Test
    public void test1() {
        // 构造器1
        File file1 = new File("hello.text");// 相对于当前Module
        File file2 = new File("E:\\Github Depository\\Java\\JavaSenior\\Day09\\he.text");// 绝对路径

        System.out.println(file1);
        System.out.println(file2);

        // 构造器2
        File file3 = new File("E:\\Github Depository\\Java", "JavaSenior");
        System.out.println(file3);

        // 构造器3
        File file4 = new File(file3, "hi.text");
        System.out.println(file4);
    }
}
