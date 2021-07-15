package src.com.exe.lockthread;

/**
 * @Description:使用同步机制将单例模式的懒汉式改写为线程安全
 * @Author RileyShen
 * @Create 2021-07-14
 */
public class BankTest {
}

class Bank {


    private Bank() {
    }

    private static Bank instance = null;

    //    public static Bank getInstance() { // 原懒汉式
//public static synchronized Bank getInstance() { // 同步： Bank类 1.
//
//
//            if (instance == null) {
//                // 线程会阻塞或者cpu切换线程，导致多次赋值，引发安全问题， instance是共享数据
//                instance = new Bank();
//
//            }
//            return instance;
//        }
//    }
//}
    public static Bank getInstance() {
//
//        synchronized (Bank.class) { // 效率稍差， 线程会进入代码块内才知道，后面的线程都在等
//            if (instance == null) {
//
//                instance = new Bank();
//
//            }
//            return instance;
//        }
//    }
// 方法2 ：
//public static Bank getInstance() {
//     包一层，提高效率

        if (instance == null) {
            synchronized (Bank.class) { // 只用进入几个，大部分都不会
                if (instance == null) {

                    instance = new Bank();

                }

            }
        }
        return instance; // 这里不认为在操作共享数据
    }
}

