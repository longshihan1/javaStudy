package Thread.ThreadDemo.zongjie;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/20.
 */
public class OrnamentalGarden {
    public static void main(String args[]) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(2);
        Entrance.cancel();
        exec.shutdown();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("么有任务");
        }
        System.out.println("Total" + Entrance.getToalCount());
        System.out.println("sun of En " + Entrance.SumEntrances());
    }
}
