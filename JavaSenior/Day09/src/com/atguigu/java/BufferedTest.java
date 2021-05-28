package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * 1.缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * <p>
 * 2.作用：提供流的读取写入速度
 *
 * @author chenglongsheng
 * @create 2021-05-27 21:43
 */
public class BufferedTest {
    /*
    复制非文本文件
     */
    @Test
    public void testBufferStream() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("yasuogou.jpg");
            File deskFile = new File("yasuogou2.jpg");
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(deskFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取输出
            byte[] Buffer = new byte[10];
            int len = bis.read(Buffer);
            while (len != -1) {
                bos.write(Buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4关闭流资源（先关闭外层流，再关闭内层流）
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时内层流也会同时关闭。内层流可以省略
//        fis.close();
//        fos.close();
        }
    }
}
