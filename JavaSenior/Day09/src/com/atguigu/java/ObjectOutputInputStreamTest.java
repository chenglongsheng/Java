package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * @author chenglongsheng
 * @create 2021-06-04 10:39
 */
public class ObjectOutputInputStreamTest {

    /*
    序列化过程：将内存中的Java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            //
            oos = new ObjectOutputStream(new FileOutputStream("data.dat"));

            //
            oos.writeObject(new String("我爱你！"));
            oos.flush();

            oos.writeObject(new Person("陈道兴", 23));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    //
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化：将磁盘文件还原为内存中的一个Java对象
     */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("data.dat"));

            Object read = ois.readObject();
            String str;

            Person p = (Person) ois.readObject();

            str = (String) read;

            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
