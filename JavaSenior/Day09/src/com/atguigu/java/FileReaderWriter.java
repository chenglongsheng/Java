package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 * <p>
 * 二、流的体系结构
 * 抽象基类            节点流（或文件流）           缓冲流
 * InputStream         FileInputStream             BufferedInputStream
 * OutputStream        FileOutputStream            BufferedOutputStream
 * Reader              FileWriter                  BufferedWriter
 *
 * @author chenglongsheng
 * @create 2021-05-24 19:33
 */
public class FileReaderWriter {

    @Test
    public void testFileReader() throws IOException {
        // 1.实例化File类的对象，指明要操作的对象
        File file = new File("hello.text");
        // 2.提供具体的流
        FileReader fileReader = new FileReader(file);
        // 3.数据的读入
        // read()：返回读入的一个字符。如果达到文件末尾，返回-1
        int read = fileReader.read();
        while (read != -1) {
            System.out.print((char) read);
            read = fileReader.read();
        }
        // 4.流的关闭操作
        fileReader.close();
    }

    @Test
    public void testFileReader1() {
        // 1.File类的实例化
        FileReader fr = null;
        try {
            File file = new File("hello.text");

            // 2.FileReader流的实例化
            fr = new FileReader(file);

            // 3.读入操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                // 错误写法
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);// HelloWorld123ld 原因：每次读入5个进数组，且是覆盖前一个，当个数不足5时，就出现123ld
//            }
                // 正确写法
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);

                }
                // 错误写法，对应方式一的错误写法
//                String str = new String(cbuf);
//                System.out.print(str);
                // 正确写法
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {

                // 4.资源关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
