package com.atguigu.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author chenglongsheng
 * @create 2021-05-29 14:04
 */
public class PicTest {

    @Test
    public void test1() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
//            fis = new FileInputStream("yasuogousecret.jpg");
//            fos = new FileOutputStream("yasuogou.jpg");
            fis = new FileInputStream("yasuogou.jpg");
            fos = new FileOutputStream("yasuogousecret.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //字节数组进行修改
                // 错误的
                //            for(byte b : buffer) {
                //                b = (byte) (b^5);
                //            }

                // 正确的
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

}
