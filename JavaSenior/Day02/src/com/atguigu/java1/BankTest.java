package com.atguigu.java1;

/**
 * @author chenglongsheng
 * @create 2021-04-11 16:02
 * 单例模式懒汉式改线程安全问题
 */
public class BankTest {
}

class Bank {

    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {

        //低效率
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//        }
//        return instance;
        if(instance == null){
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }

        }
        return instance;
    }
}
