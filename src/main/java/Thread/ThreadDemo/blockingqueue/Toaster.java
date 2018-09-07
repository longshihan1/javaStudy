package Thread.ThreadDemo.blockingqueue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/21.
 */
public class Toaster implements Runnable {
    private ToastQueue toastsQueue;
    private int count=0;
    private Random random=new Random(47);

    public Toaster(ToastQueue toastsQueue) {
        this.toastsQueue = toastsQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100+random.nextInt(500));
                Toast t=new Toast(count++);
                toastsQueue.put(t);
                System.out.println("Toaster :"+t);
            }
        }catch (InterruptedException e){
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}
