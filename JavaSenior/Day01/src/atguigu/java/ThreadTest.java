package atguigu.java;

/**
 * 1.创建一个继承Thread类的子类
 * 2.重写Tread类的run()————>将此线程执行的操作声明在run()中
 * 3.创建Treated类的子类的对象
 * 4.通过此对象调用start()
 * pl:遍历100以内的所有偶数
 *
 * @author chenglongsheng
 * @create 2021-04-02 9:20
 */
//    1.创建一个继承Thread类的子类
class MyThread extends Thread {
    //2.重写Tread类的run()————>将此线程执行的操作声明在run()中
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
//      3.创建Treated类的子类的对象
        MyThread t1 = new MyThread();
//        4.通过此对象调用start()（1）启动当前线程（2）调用当前线程的run()
        t1.start();

        t1.run();
        System.out.println("hello");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "**********main()*************");
            }
        }
    }
}