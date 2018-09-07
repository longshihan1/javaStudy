package Thread.ThreadDemo.zongjie;

import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/20.
 */
public class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting  SleepBlocked  ");
    }
}
