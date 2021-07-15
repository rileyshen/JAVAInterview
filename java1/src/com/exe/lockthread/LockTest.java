package src.com.exe.lockthread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:解决线程安全问题： Lock锁
 *
 * 优先使用顺序：
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法
 * （在方法体之外）
 *
 * @Author RileyShen
 * @Create 2021-07-15
 */

class Window implements Runnable {

    private int ticket  = 100;

    // 实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            try {
                // 调用锁定的方法： lock()
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": 售票， 票号为： " + ticket);
                    ticket--;
                } else {
                    break;

                }

            } finally {
                // 调用解锁的方法： unlock()
                lock.unlock();
            }
        }

    }
}

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
    }

}
