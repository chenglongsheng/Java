package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 * 1.File类的一个对象，代表一个文件或一个文件目录（文件夹）
 * 2.File类声明在Java.io包下
 * 3.File类中涉及到关于文件或文件目录的创建、重命名、修改时间、文件大小等方法，
 *  并未涉及到写入或读取文件内容的操作。如果需要读取或者写入文件内容，必须使用IO流来完成。
 * 4.File类的对象常会作为参数传递到流的构造器，指明读取或写入的“终点”。
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

    @Test
    /*
    file类的常用方法
     */
    public void test2() {
        File file1 = new File("hello.text");
        File file2 = new File("d:\\io\\hi.text");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

    }

    @Test
    public void test3() {
        File file = new File("E:\\Github Depository\\Java\\JavaSenior");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    @Test
    /*
    返回true的条件，file1要存在，file2不能存在
     */
    public void test4() {
        File file1 = new File("hello.text");
        File file2 = new File("E:\\io\\hi.text");
        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);
    }

    @Test
    public void test5() {
        File file1 = new File("hello.text");

        System.out.println(file1.isDirectory());// 是否文件目录
        System.out.println(file1.isFile());// 是否文件
        System.out.println(file1.exists());// 是否存在
        System.out.println(file1.canRead());// 是否可读
        System.out.println(file1.canWrite());// 是否可写
        System.out.println(file1.isHidden());// 是否隐藏

        System.out.println("**************");
        File file2 = new File("e:\\io");

        System.out.println(file1.isDirectory());// 是否文件目录
        System.out.println(file1.isFile());// 是否文件
        System.out.println(file1.exists());// 是否存在
        System.out.println(file1.canRead());// 是否可读
        System.out.println(file1.canWrite());// 是否可写
        System.out.println(file1.isHidden());// 是否隐藏
    }

    /*
    创建硬盘中对应的文件或者文件目录
    public boolean createNewFile()：创建文件。若文件存在，则不创建，返回false。
    public boolean mkdir()：创建文件目录。如目录存在，则不创建，返回false。
    public boolean mkdirs()：创建文件目录。如果上层文件目录不存在，一并创建。

    删除磁盘中的文件或者文件目录
    public boolean delete()：删除文件或者文件夹（Java中不走回收站）
     */
    @Test
    public void test6() throws IOException {
        File file1 = new File("hi.text");
        if (!file1.exists()) {
            file1.createNewFile();
            System.out.println("创建成功");
        } else {
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test7() {
        File file1 = new File("e:\\io\\io1\\io3");

        boolean mkdir = file1.mkdir();
        if (mkdir) {
            System.out.println("创建成功1");
        }

        File file2 = new File("e:\\io\\io1\\io4");

        boolean mkdirs1 = file2.mkdir();
        if (mkdirs1) {
            System.out.println("创建成功2");
        }

    }
}
