package ThreadDemo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 计数器
 * Created by dell on 2017/2/24.
 */
public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            //模拟任务
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(10) * 1000);
            System.out.println("Check complete ");
            end.countDown();//倒计时器-1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.submit(demo);
        }
        end.await();//等待从10变成0.在同一执行下步
        System.out.println("OK");
        exec.shutdownNow();
    }
}
