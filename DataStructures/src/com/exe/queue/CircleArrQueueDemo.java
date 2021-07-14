package src.com.exe.queue;

import java.util.Scanner;

/**
 * @Description: 环形数组，通过取模的方式取得 可以复用
 * 物理意义： front： arr[front]是队列第一个元素。 front = 0；
 *           rear： arr[rear] 队列最后元素的后一个位置 real = 0；
 *
 *
 *      浪费一个空间做约定
 *
 *  当队列满时：(rear + 1 ) % maxSize = front
 *   当队列空时：real = front
 *
 *  队列中有效的数据个数：(real + maxSize - front) % maxSize // rear = 1 front = 0
 *
 * @Author RileyShen
 * @Create 2021-07-14
 */
public class CircleArrQueueDemo {
    public static void main(String[] args) {
        // 创建一个队列
        CircleArray queue = new CircleArray(4); // 其队列有效数据最大为3
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
                    queue.showQueue();
                    break;

                case 'a':
                    System.out.println("输入一个数据");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;

                case 'g':

                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 'h':

                    try {
                        int res = queue.peek();
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
class CircleArray {
    private int maxSize; // 表示数组最大容量
    private int front; // 物理意义： front： arr[front]是队列第一个元素。
    private int rear; // 物理意义：rear： arr[rear] 队列最后元素的后一个位置
    private int[] arr; // 该数组用于存放数据

    // 创建队列的构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; //  front = 0；

        rear = 0; //  real = 0；
    }

    // 判断队列是否为满
    public boolean isFull() {
        return (rear + 1 ) % maxSize == front;
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
         // 直接将数据加入
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 出数据队列
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据"); // 自己就return
        }
        // 先把front对应的值保留到一个临时变量，不能直接
        // 将front后移
        //将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }

        // 从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);


        }

    }

    // 求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据
    public int peek() {
        // 遍历
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }

}
