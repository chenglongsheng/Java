package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenglongsheng
 * @create 2021-04-12 8:25
 *
 * 同：二者都可以解决线程安全问题
 * 异：synchronized机制在执行完相应的代码块后，自动释放同步监视器
 *    Lock需要手动启动同步（lock()），同时结束同步也需要手动实现（unlock()）
 * 优先使用：lock>同步代码块（进入方法体，分配了相应资源）>同步方法（在方法体之外）
 * 如何解决线程安全问题？有几种方式？
 * 三种方式：synchronized同步方法和同步代码块，lock
 * 两种方式：synchronized和lock
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
        int a = 3;
        a=a++ + ++a;
        System.out.println(a);
    }
}

class Window implements Runnable {

    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 调用lock()
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：售票, 票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                // 解锁
                lock.unlock();
            }
        }
    }
}
