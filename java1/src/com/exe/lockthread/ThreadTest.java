package src.com.exe.lockthread;

/**
 * @Description:线程死锁问题
 * 1. 不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃
 * 自己需要的同步资源，就形成了线程的死锁
 * 2. 使用同步时要避免使用死锁
 *
 *
 *
 * @Author RileyShen
 * @Create 2021-07-14
 */
public class ThreadTest {

    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {

                synchronized (s1) {

                    s1.append("a");
                    s2.append("1");

                    // 增加Thread Lock几率
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2) {

                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);

                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (s2) {

                    s1.append("c");
                    s2.append("3");

                    // 增加Thread Lock几率
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    synchronized (s1) {

                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);

                    }
                }
            }
        }).start();
    }
}
