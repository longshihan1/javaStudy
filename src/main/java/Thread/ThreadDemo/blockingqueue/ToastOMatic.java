package Thread.ThreadDemo.blockingqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/21.
 */
public class ToastOMatic {
    public static void main(String args[]) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue();
        ToastQueue butterQueue = new ToastQueue();
        ToastQueue finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butterQueue));
        exec.execute(new Jammer(butterQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();

    }
}
