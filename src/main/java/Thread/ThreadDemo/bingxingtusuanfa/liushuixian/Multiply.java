package Thread.ThreadDemo.bingxingtusuanfa.liushuixian;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 线程乘法
 * Created by dell on 2017/2/28.
 */
public class Multiply implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true) {
            try {

                Msg msg = bq.take();
                msg.i = msg.i * msg.j;
                Div.bq.add(msg);
            } catch (InterruptedException e) {
                System.out.println(e + " InterruptedException");
            }
        }
    }
}
