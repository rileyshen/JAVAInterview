package src.com.exe.exer;

/**
 * @Description: 创建两个分线程，其中一个线程遍历100以内的偶数，另一个遍历100以内的奇数
 * @Author RileyShen
 * @Create 2021-07-12
 */

public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 m1 = new MyThread1();
//        MyThread2 m2 = new MyThread2();
//
//        m1.start();
//        m2.start();

        // 创建Thread类的匿名子类的方式, MyThread1只用了一次，后面也不用的情况下

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}

//class MyThread1 extends Thread {
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 0) {
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//            }
//        }
//    }
//}
//
//class MyThread2 extends Thread {
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 != 0) {
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//            }
//        }
//    }
//}