package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutputStream
 * <p>
 * 对于文本文件（txt,java,c,cpp），使用字符流处理
 * 对于非文本文件(jpg,mp3,mp4,avi,doc,ppt...)，使用字节流处理
 *
 * @author chenglongsheng
 * @create 2021-05-26 20:24
 */
public class FileInputStreamTest {

    /*
    使用字节流处理文本文件是可能出现乱码的
     */
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1.造文件
            File file = new File("hello.text");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取的字节的个数
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {

                //4.关
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
