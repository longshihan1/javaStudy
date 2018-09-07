package Thread.ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/16.
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+""+this);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("sleep ");
        }
    }

    public static void main(String args[]) throws InterruptedException {
        /*for (int i = 0; i < 10; i++) {
            Thread daemon=new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        S*/
        ExecutorService exec= Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new SimpleDaemons());
        }

        System.out.println("All ");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
