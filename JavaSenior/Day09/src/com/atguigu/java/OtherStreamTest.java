package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 其它流的使用；
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 *
 * @author chenglongsheng
 * @create 2021-05-31 18:42
 */
public class OtherStreamTest {

    /*
    标准的输入、输出流
    System.in：标准的输入流，默认从键盘输入
    System.out：标准的输出流，默认从控制台输出
     */
    @Test
    public void test() {

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    数据流
    DataInputStream  DataOutputStream
    用于读取或写出基本数据类型的变量或字符串
     */
    @Test
    public void test1() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));

            dos.writeUTF("陈道兴");
            dos.flush();
            dos.writeInt(23);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    将文件中读取的基本数据类型变量和字符串读取到内存中，保存在变量中
    读取不同的数据类型的顺序要和当初写文件一致
     */
    @Test
    public void test2() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("data.txt"));

            String s = dis.readUTF();
            int i = dis.readInt();
            boolean b = dis.readBoolean();

            System.out.println("name:" + s);
            System.out.println("age:" + i);
            System.out.println("isMale:" + b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
