package com.atguigu.java;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    public static void main(String[] args) {

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

}
