package src.com.exe.thread;

/**
 * @Description:创建三个窗口卖票，总票数为100张,使用实现Runnable接口的方式
 * 问题： 卖票过程中出现重票，错票，--》 线程安全问题
 * 问题出现的原因，当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
 *如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来，知道线程a操作完成ticket时候
 *         其他线程才可以开始操作ticket，这种情况即使线程a出现阻塞，也不能被改编
 *
 *4. dava中通过同步机制，来解决线程安全
 *
 *  方式2： 同步方法解决Runnable线程安全问题

 * 2. 同步方法仍然设计到同步监视器，只是不需要我们显式的声明
 * 3. 非静态的同步方法，同步监视器是： this
 *      静态同步方法，同步监视器是： 当前类本身
 *
 *
 *
 * 解决了线程安全问题，
 * 只有一个线程参与，其他等待，效率低
 *
 *
 *
 * @Author RileyShen
 * @Create 2021-07-12
 */
class Window3 implements Runnable {

    // 这里不需要用static，因为只造了一个对象，放进了3个构造器中
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {


            show();


        }
    }

    private synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println(Thread.currentThread().getName() + ": 卖票， 票号为： " + ticket);

            ticket--;
        }
    }
}

public  class Window3Test {
    public static void main(String[] args) {
        Window3 w = new Window3();

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

