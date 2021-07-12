package src.com.exe.thread;

/**
 * @Description:多线程创建： 方式一： 继承Thread类
 * 1、创建一个继承于Thread类的子类
 * 2、重写Thread类的run（）方法 --> 将此线程执行的操作声明在run()
 * 3、创建Thread类子类的对象 -->需要在主线程去做
 * 4、通过此对象调用start（）
 *
 * 例子： 遍历100以内的所有偶数
 *
 * @Author RileyShen
 * @Create 2021-07-12
 */

// 1、创建一个继承于Thread类的子类
class MyThread extends Thread {
   // 2、重写Thread类的run（）方法


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                System.out.println(i);
                System.out.println(getName() + ":" + i);
            }

        }
    }
}


public class ThreadTest {
  // 3、创建Thread类子类的对象 -->需要在主线程去做
  public static void main(String[] args) {

      MyThread t1 = new MyThread();

     // 4、通过此对象调用start（）
      t1.start();
//      t1.run();
// 再测试下多创建个新线程呢
//      t1.start();
// 不可以让已经执行start()的线程去执行，会报IllegalThreadStateException

      // 再启动新线程，需要新一个对象
      MyThread t2 = new MyThread();
      t2.start();


      for (int i = 0; i < 100; i++) {
          if (i % 2 == 0) {
              System.out.println(Thread.currentThread().getName() + ":" + i +"*************main()***************");
          }
      }
  }
}
