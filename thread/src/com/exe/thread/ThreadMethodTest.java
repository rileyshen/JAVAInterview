package src.com.exe.thread;

/**
 * @Description: 测试Thread中常用方法：
 * 1. start():启动当前线程，调用当前线程的run()
 * 2. run(): 通常需要重写Thread类的此方法，将创建的线程要执行的操作声明在此方法中
 * 3. currentThread(): 静态方法，返回当前代码执行的线程
 * 4. getName():
 * 5. setName():除了在主线程中运用setName外，可以直接用带 name 的参数的构造器创建线程
 * 6. yield()
 * 7. join():在线程a中调用线程b的join（），此时线程a就进入阻塞状态，直到线程b完成执行完以后，线程a才借宿阻塞状态
 * 8. sleep(Long millistime):过年倒计时会用这种
 * 9. isAlive():判断当前线程是否存活
 * 10. 线程优先级:
 *  getPriority():
 *  setPriority(int p)

 *
 *
 *
 * @Author RileyShen
 * @Create 2021-07-12
 */
class HelloThread extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

//                // * 8. sleep(Long millistime)
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + ":" + i);
            }



//            // 6. yield()
//            if (i % 20 == 0) {
//                yield();
//            }

        }
    }


    // 可以直接用带 name 的参数的构造器创建线程
    public HelloThread(String name) {
        super(name);
    }
}
public class ThreadMethodTest {
    public static void main(String[] args) {


        HelloThread h1 = new HelloThread("Thread: 1");
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();

        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

//            // 7. join()
//            if (i == 20) {
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

//        System.out.println(h1.isAlive());
    }

}
