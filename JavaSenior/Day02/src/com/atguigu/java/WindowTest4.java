package com.atguigu.java;

/**
 * @author chenglongsheng
 * @create 2021-04-11 15:45
 *
 * 1.同步方法仍需要同步监视器
 * 2.非静态对象时this
 *  静态对象是当前类
 */
class Window4 extends Thread {

    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {

            show();
        }
    }

    private static synchronized void show() {//同步监视器Window4.class
    //private synchronized void show() {//this:t1,t2,t3,此种方法时错误的
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket--;
        }
    }
}


public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
