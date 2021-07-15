package src.com.exe.threadcom;

/**
 * @Description:线程通信例子： 使用两个线程打印 1-100。线程1, 线程2 交替打印
 *
 * 涉及到3个方法：
 * wait():线程进入阻塞，并释放同步监视器
 * notify()"就会环形被wait的一个线程，如果有多个，就唤醒优先级高的
 * notifyAll():
 *
 * 说明： 这三个方法只有在synchronized方法或synchronized代码块中才能使用，否则会报
 * java.lang.IllegalMonitorStateException异常。
 *
 * 这三个方法的调用者必须是同步代码块或者同步方法中的同步监视器
 *
 * 3. 这三个方法是定义在object类下面的，不是Thread类下面的
 *
 * 面试题： sleep()和wait()异同？
 *
+ ***共同点： 一旦执行，都可以使得当前线程进入阻塞***

+ ***不同点： 1. 两个方法声明的位置不同： Thread类中声明sleep(), Object类中申明wait()***

+ ***不同点： 2. 调用要求不同： sleep()可以在任何需要的场景下调用, wait()必须在同步代码块或者同步方法***

+ ***不同点： 3. 释放同步监视器的问题： 如果两个方法都用在同步代码块或者同步方法中，sleep()不会释放释放同步监视器, wait()会释放释放同步监视器***
 *
 * @Author RileyShen
 * @Create 2021-07-15
 */
class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {

        while (true) {

//            synchronized (obj) { 这三个方法的调用者必须是同步代码块或者同步方法中的同步监视器
            synchronized (this) {

//                notify();  所以这里和下面的wait（）都要改为obj.notify()来保持一致
                notify();

                if (number <= 100) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
