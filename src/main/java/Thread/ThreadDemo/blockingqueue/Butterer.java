package Thread.ThreadDemo.blockingqueue;

import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/21.
 */
public class Butterer implements Runnable{
    private ToastQueue dryQueue,bufferedQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue bufferedQueue) {
        this.dryQueue = dryQueue;
        this.bufferedQueue = bufferedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t=dryQueue.take();
                t.butter();
                System.out.println(t);
                bufferedQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Bufferer InterruptedException");
        }
        System.out.println("Buffer OFf");
    }
}
