package com.atguigu.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户
 * 两个储户分别向同一个账户存3000，每次一千且打印凭证
 *
 * @author chenglongsheng
 * @create 2021-04-13 9:48
 */
class Account {

    private double balance;
    private static ReentrantLock lock = new ReentrantLock();

    public Account(double balance) {
        this.balance = balance;
    }

    // 存钱
    public /*synchronized*/ void deposit(double amt) {
        lock.lock();
        if (amt > 0) {
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "存钱成功。余额为：" + balance);
        }
        lock.unlock();
    }
}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

public class AccountTest {

    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }

}
