package src.com.exe.thread;

/**
 * @Description: 同步方法解决继承
 * @Author RileyShen
 * @Create 2021-07-12
 */
class Window3s extends Thread {

    // 方案1：造成的结果是卖出了300张票，因为每个window子对象都有100个。
//    private int ticket = 100;

    // 做成静态对象，共享: 大部分都是不同票，除了偶尔还有出现3个窗口卖同一个票号的票，这就是线程不安全
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

//    private synchronized void show() { 同步监视器：三个， t1, t2, t3不安全, 要保证show方法是静态
        private static synchronized void show() {
        // 这时候同步监视器是唯一的，window3s
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


//            System.out.println(getName() + ": 卖票， 票号为： " + ticket);
            System.out.println(Thread.currentThread().getName() + ": 卖票， 票号为： " + ticket);
            ticket--;
        }


    }
}


public class Window3T {
    public static void main(String[] args) {

        Window3s t1 = new Window3s();
        Window3s t2 = new Window3s();
        Window3s t3 = new Window3s();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();



    }
}
