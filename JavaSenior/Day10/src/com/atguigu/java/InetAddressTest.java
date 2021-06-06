package com.atguigu.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author chenglongsheng
 * @create 2021-06-06 20:32
 */
public class InetAddressTest {
    public static void main(String[] args) {

        InetAddress inet1 = null;
        try {
            inet1 = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(inet1);
        System.out.println();
    }
}
