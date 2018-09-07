package Thread.ThreadDemo.bingxingtusuanfa.liushuixian;

import Thread.ThreadDemo.xunhuan.Meal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 线程加法
 * Created by dell on 2017/2/28.
 */
public class Plus implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true) {
            try {

                Msg msg = bq.take();
                msg.j = msg.i + msg.j;
                Multiply.bq.add(msg);
            } catch (InterruptedException e) {
                System.out.println(e + " InterruptedException");
            }
        }
    }
}
