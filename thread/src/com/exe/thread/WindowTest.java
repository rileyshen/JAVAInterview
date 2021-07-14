package src.com.exe.thread;

/**
 * @Description:创建三个窗口卖票，总票数为100张,使用继承Thread类的方式
 * @Author RileyShen
 * @Create 2021-07-12
 */
class Window extends Thread {

    // 方案1：造成的结果是卖出了300张票，因为每个window子对象都有100个。
//    private int ticket = 100;

    // 做成静态对象，共享: 大部分都是不同票，除了偶尔还有出现3个窗口卖同一个票号的票，这就是线程不安全
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {

            if (ticket > 0) {

                System.out.println(getName() + ": 卖票， 票号为： " + ticket);
                ticket--;
            } else {
                break;
            }


        }
    }
}
public class WindowTest {
    public static void main(String[] args) {

        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();



    }
}
