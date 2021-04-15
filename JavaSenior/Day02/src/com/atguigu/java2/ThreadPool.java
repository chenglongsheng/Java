package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 第四种方法：使用线程池
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *      corePoolSize：核心池的大小
 *      maximumPoolSize：最大线程数
 *      keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 *  JDK 5.0起提供了线程池相关API：ExecutorService 和 Executors
 *  ExecutorService：真正的线程池接口。常见子类ThreadPoolExecutor
 *  void execute(Runnable command) ：执行任务/命令，没有返回值，一般用来执行
 * Runnable
 *  <T> Future<T> submit(Callable<T> task)：执行任务，有返回值，一般又来执行
 * Callable
 *  void shutdown() ：关闭连接池
 *  Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池
 *  Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池
 *  Executors.newFixedThreadPool(n); 创建一个可重用固定线程数的线程池
 *  Executors.newSingleThreadExecutor() ：创建一个只有一个线程的线程池
 *  Executors.newScheduledThreadPool(n)：创建一个线程池，它可安排在给定延迟后运
 * 行命令或者定期地执行。
 *
 * @author chenglongsheng
 * @create 2021-04-15 20:45
 */
class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}

class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定的线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2.执行指定的线程操作，需要提供实现Runnable接口或者Callable接口实现类的对象
        service.execute(new NumberThread());
        service.execute(new NumberThread1());//Runnable接口
        //service.submit();//Callable接口

        //3.关闭线程池
        service.shutdown();
    }
}
