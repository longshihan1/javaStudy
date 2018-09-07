package Thread.ThreadDemo.bingxingtusuanfa.liushuixian;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by dell on 2017/2/28.
 */
public class Div implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true) {
            try {

                Msg msg = bq.take();
                msg.j = msg.i/2;
                System.out.println(msg.orgStr+"="+msg.i);
            } catch (InterruptedException e) {
                System.out.println(e + " InterruptedException");
            }
        }
    }
}
