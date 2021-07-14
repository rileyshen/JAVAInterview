package src.com.exe.queue;

import java.util.Scanner;

/**
 * @Description: 一次性数组，不能复用
 * @Author RileyShen
 * @Create 2021-07-14
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; // 接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加队列");
            System.out.println("g(get):取出数据");
            System.out.println("p(peek):查看队头部");
            key = scanner.next().charAt(0); // 接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;

                case 'a':
                    System.out.println("输入一个数据");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;

                case 'g':

                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 'h':

                    try {
                        int res = arrayQueue.peek();
                        System.out.printf("队列头数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;


                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }

        System.out.println("程序推出~~~");
    }
}
// [)
// 使用数组模拟队列
class ArrayQueue {
    private int maxSize; // 表示数组最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数组用于存放数据

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 物理意义：指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1; // 物理意义： 指向队列尾部，指向对位尾的数据，包含队列最后一个数据
    }

    // 判断队列是否为满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否为满
        if (isFull()) {
            System.out.println("队列满，无法加入");
            return;
        }
         // 让rear后移
        arr[++rear] = n;
    }

    // 出数据队列
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据"); // 自己就return
        }

       return arr[++front]; // front后移
    }

    // 显示队列所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);


        }
    }

    // 显示队列的头数据
    public int peek() {
        // 遍历
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front + 1];
    }

}
