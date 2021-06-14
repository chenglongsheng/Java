package com.atguigu.java;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议的网络编程
 *
 * @author chenglongsheng
 * @create 2021-06-14 18:09
 */
public class UDPTest {

    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();

        String str = "你好，我是UDP！";
        byte[] buffer = str.getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, inet, 9898);

        socket.send(packet);

        socket.close();

    }

    @Test
    public void receiver() throws IOException {

        DatagramSocket socket = new DatagramSocket(9898);
        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        socket.close();

    }

}
