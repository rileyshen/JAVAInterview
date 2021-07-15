package src.com.exe.threadproject;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * 银行有一个账户，有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 * 分析：
 * 1. 明确哪些代码是多线程? 是， 两个储蓄线程
 * 2. 是否有共享数据？ 有， 账户余额
 * 3.是否有线程安全问题？ 有。有共享数据， 有两个线程都对它操作。
 * 4. 如何解决线程安全问题？ 同步机制： 3种
 *
 *
 * @Author RileyShen
 * @Create 2021-07-15
 */
class Account {
    private double balance;
    private ReentrantLock lock = new ReentrantLock();

    public Account(double balance) {
        this.balance = balance;
    }

    // 存钱
    public void deposit(double amt) {
        try {
            lock.lock();

            if (amt > 0) {

                balance += amt;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "余额为： " + balance);

            }
        } finally {
            lock.unlock();
        }
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
