package Thread.ThreadDemo.CountDown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/22.
 */
public class TaskPortion implements Runnable {

    private static int count=0;
    private final int id=count++;
    private static Random rand=new Random(47);
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        try{
            doWork();
            latch.countDown();
        }catch(InterruptedException e){
            //System.out.println(e+" InterruptedException");
        }
    }

    private void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this+" completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d",id);
    }
}
