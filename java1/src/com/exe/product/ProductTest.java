package src.com.exe.product;

/**
 * @Description:线程通信的应用： 经典例题：生产者/消费者问题
 *
 * 生产者(Producer)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 *
 *  * 分析：
 *  * 1. 明确哪些代码是多线程? 是， Productor, Customer
 *  * 2. 是否有共享数据？ 有， 店员/product数量
 *  * 3.是否有线程安全问题？ 有。有共享数据， 有两个线程都对它操作。
 *  * 4. 如何解决线程安全问题？ 同步机制： 3种
 *  * 5. 是否涉及到线程的通信？ 是
 *
 *
 * @Author RileyShen
 * @Create 2021-07-15
 */
class Clerk {
    private int num;


    public synchronized void produceProdct() {

       if (num < 20) {
           num++;
           System.out.println(Thread.currentThread().getName() + ":开始生产" + num);

           // 生产了一个，就可以唤醒对面消费者
           notify();

       } else {
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }



    }

    public synchronized void consumeProdct() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + num);
            num--;

            notify();

        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品......");
        
        while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProdct();
        }
    }
}

class Customer extends Thread {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品......");

        while (true) {

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProdct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);

        Customer c1 = new Customer(clerk);
        Customer c2 = new Customer(clerk);

        p1.setName("厂商");
        c1.setName("顾客");
        c2.setName("顾客2");

        p1.start();
        c1.start();
        c2.start();
    }
}
