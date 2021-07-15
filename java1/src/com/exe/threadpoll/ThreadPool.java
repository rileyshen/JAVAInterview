package src.com.exe.threadpoll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:创造多线程的第四种方式：线程池
 *
 *
 *
 *
 * @Author RileyShen
 * @Create 2021-07-15
 */
class NumberThread implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

class NumberThread1 implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {

        //1.
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 设置线程池的属性
        System.out.println(service.getClass()); // 得到class java.util.concurrent.ThreadPoolExecutor
        ThreadPoolExecutor service1 = ((ThreadPoolExecutor) service);
        service1.setCorePoolSize(5);


        service.execute(new NumberThread()); //适合与Runnable
        service.execute(new NumberThread1()); //适合与Runnable

        service.shutdown();
//        service.submit(); //适合与Callable
    }
}
