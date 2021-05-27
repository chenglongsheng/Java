package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    /*
    实现对图片的复制操作
     */
    @Test
    public void testFileOutputStream() {
        //
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("yasuogou.jpg");
            File desFile = new File("yasuogou1.jpg");

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            // 复制的过程
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void copyFile(String srcPath, String deskPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File desFile = new File(deskPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            // 复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();
        String srcPath = "hello.text";
        String deskPath = "hello3.text";//操作花费时间：5
//        String srcPath = "F:\\mybatis\\mybatis-缓存.mov";
//        String deskPath = "F:\\mybatis\\mybatis-缓存1.mov";
        copyFile(srcPath, deskPath);
        long end = System.currentTimeMillis();
        System.out.println("操作花费时间：" + (end - start));//操作花费时间：1814
    }

}
