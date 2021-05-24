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

}
