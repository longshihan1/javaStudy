package Thread.ThreadDemo.CountDown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/22.
 */
public class WaitingTask implements Runnable {
    private static int count=0;
    private final int id=count++;
    private static Random rand=new Random(47);
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        try{
            latch.await();
            System.out.println("Latch barrier passed for"+this);
        }catch(InterruptedException e){
            System.out.println(e+" InterruptedException");
        }
    }



    @Override
    public String toString() {
        return String.format("Waiting Task  %1$-3d",id);
    }
}
