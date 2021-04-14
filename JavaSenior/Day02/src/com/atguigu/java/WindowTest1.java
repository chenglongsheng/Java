package com.atguigu.java;

/**
 * @author chenglongsheng
 * @create 2021-04-06 15:08
 *
 * 存在线程安全问题，待解决
 * 1.问题：卖票过程中，出现了重票、错票-->出现了线程安全问题
 * 2.原因：档某个线程操作ticket的时候，其他线程不能参与进来。直到线程A 操作完ticket时，
 *         线程才可以开始操作ticket。这种情况即使线程A出现了阻塞，也不能被改变。
 * 3.在Java中，通过同步机制，来解决线程的安全问题
 *
 * 方式一：同步代码块
 *  synchronized(同步监视器){
 *      //需要被同步的代码块
 *  }
 *  说明：1.操作共享数据的代码，即为需要被同步的代码
 *       2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据。
 *       3.同步监视器，俗称：锁。任何一个类的对象,都可以充当对象
 *          要求：多个线程必须共用同一把锁
 *
 * 方式二：同步方法
 *      如果同步代码块完整在一个方法中，将此方法声明同步
 */
class Window1 implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {

            //synchronized (obj) {
              synchronized (this){ //this为window1对象
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
