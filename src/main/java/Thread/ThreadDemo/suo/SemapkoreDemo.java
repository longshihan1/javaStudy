package Thread.ThreadDemo.suo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/23.
 */
public class SemapkoreDemo {
    private static int SIZE = 25;

    public static void main(String args[]) throws InterruptedException {
        final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new CheckoutTask<Fat>(pool));
        }
        System.out.println("All Checkout created");
        List<Fat> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            Fat t = pool.checkOut();
            System.out.println(i + " main() thread checkout");
            t.operation();
            list.add(t);
        }
        Future<?> blocked = exec.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    pool.checkOut();
                } catch (InterruptedException e) {
                    System.out.println("Checkout()  InterruptedException");
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);
        System.out.println("Checkout in objecy in" + list);
        for (Fat f : list) {
            pool.checkIn(f);
        }
        for (Fat f : list) {
            pool.checkIn(f);
        }
        exec.shutdownNow();
    }
}
