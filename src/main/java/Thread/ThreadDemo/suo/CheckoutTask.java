package Thread.ThreadDemo.suo;

import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/23.
 */
public class CheckoutTask<T> implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {

        try {
            T item = pool.checkOut();
            System.out.println(this + " Check out " + item);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + "Check in" + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            //System.out.println(e + " InterruptedException");
        }

    }

    @Override
    public String toString() {
        return "checkoutTask " + id;
    }
}
