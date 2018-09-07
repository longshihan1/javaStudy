package Thread.ThreadDemo.bingxingtusuanfa.bussessproduct.suo;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 消费者
 * Created by dell on 2017/2/27.
 */
public class Consumer implements Runnable {
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        System.out.println("start Consume id= " + Thread.currentThread().getId());
        Random r = new Random();
        try {
            while (true) {
                PCData data = queue.take();
                if (null != data) {
                    int re = data.getIntdata() * data.getIntdata();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getIntdata(), data.getIntdata(), re));
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(SLEEPTIME));
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e + " InterruptedException");
            Thread.currentThread().interrupt();
        }
    }
}
