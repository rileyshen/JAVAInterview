package src.com.exe.threadnew;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:实现Callable接口
 *
 *
 *
 *
 * @Author RileyShen
 * @Create 2021-07-15
 */
class NumThread implements Callable {


    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {

                System.out.println(i);
                sum += i;

            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        // 3.创建callable接口实现类的对象
        NumThread numThread = new NumThread();

        // 4.将此Callable接口实现类的对象作为传递到FutureTask构造器中
        FutureTask futureTask = new FutureTask(numThread);

        // 5.将FutureTask对象作为参数传到Thread类的构造器中，创建Thread对象，并启动
        new Thread(futureTask).start();

        try {
            // get()返回值即为futureTask构造器参数Callable实现类重写的call的方法的返回值
            Object sum = futureTask.get();
            System.out.println(sum);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
