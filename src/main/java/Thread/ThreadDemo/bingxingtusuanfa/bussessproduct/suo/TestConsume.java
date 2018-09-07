package Thread.ThreadDemo.bingxingtusuanfa.bussessproduct.suo;

import java.util.concurrent.*;

/**
 * Created by dell on 2017/2/27.
 */
public class TestConsume {
    public static void main(String args[]) throws InterruptedException {
        //建立缓存区
        BlockingQueue<PCData> queue = new LinkedBlockingDeque<PCData>(10);
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(producer1);
        exec.execute(producer2);
        exec.execute(producer3);
        exec.execute(consumer1);
        exec.execute(consumer2);
        exec.execute(consumer3);

        TimeUnit.SECONDS.sleep(10);

        producer1.stop();
        producer2.stop();
        producer3.stop();
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}
