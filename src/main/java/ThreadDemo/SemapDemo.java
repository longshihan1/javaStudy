package ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 * Created by dell on 2017/2/24.
 */
public class SemapDemo implements Runnable {
    //同时最多5个进入
    final Semaphore semaphore=new Semaphore(5);


    @Override
    public void run() {
        try {
            semaphore.acquire();//尝试获得准入许可，没有则等待
            //模拟耗时
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+" done!");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
     ExecutorService exec= Executors.newCachedThreadPool();
        final SemapDemo demo=new SemapDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }
    }
}
