package com.atguigu.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author chenglongsheng
 * @create 2021-05-11 9:49
 */
public class PropertiesTest {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            Properties properties = new Properties();
            fileInputStream = new FileInputStream("jdbc.properties");
            properties.load(fileInputStream);// 加载流对应文件

            String name = properties.getProperty("name");
            String password = properties.getProperty("password");

            System.out.println("name = " + name + ",password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
