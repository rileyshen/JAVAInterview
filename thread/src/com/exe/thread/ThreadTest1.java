package src.com.exe.thread;

/**
 * @Description:创建多线程方式2： 实现runnable接口
 *
 * 1. 创建了一个实现了Runnable接口的类
 * 2. 需要实现类去Runnable中的抽象方法
 * 3. 创建实现类的对象
 * 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5. 通过Thread类的方法调用start（）
 *
 *
 * @Author RileyShen
 * @Create 2021-07-12
 */
class MThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

    }
}
public class ThreadTest1 {
    public static void main(String[] args) {

        //  * 3. 创建实现类的对象
        MThread mThread = new MThread();

         //* 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);

        //  * 5. 通过Thread类的方法调用start（）
        t1.start();

        // 再启动一个线程
        Thread t2 = new Thread(mThread);
        t2.start();
    }
}
