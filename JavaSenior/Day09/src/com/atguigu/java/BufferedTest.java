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
 * 提高读取写入的速度，内部提供了一个缓冲区
 * <p>
 * 3.处理流：“套接”在已有的流基础上
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
            //3.复制的细节：读取写入
            byte[] Buffer = new byte[10];
            int len;
            while ((len = bis.read(Buffer)) != -1) {
//                bos.flush();
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

    /*
    复制文件
     */
    public void testCopyFileWithBuffer(String srcPath, String deskPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File deskFile = new File(deskPath);
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(deskFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取写入
            byte[] Buffer = new byte[1024];
            int len;
            while ((len = bis.read(Buffer)) != -1) {
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

    @Test
    public void testCopyFile1() {
        long start = System.currentTimeMillis();
        String srcPath = "E:\\io\\软件安装及解压方法..mp4";
        String deskPath = "E:\\io\\软件安装及解压方法2..mp4";
        testCopyFileWithBuffer(srcPath, deskPath);
        long end = System.currentTimeMillis();
        System.out.println("操作花费时间：" + (end - start));//操作花费时间：66
    }

    @Test
    public void testBufferedReaderBufferedWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式一： use char[]
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf)) != -1) {
//                bw.write(cbuf, 0, len);
//            }

            //方式二：use String
            String data;
            while ((data = br.readLine()) != null) {
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
