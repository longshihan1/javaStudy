package Thread.ThreadDemo.xunhuan;

import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/21.
 */
public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                    if (++count == 10) {
                        System.out.println(" out of food ,close");
                        restaurant.exec.shutdownNow();
                    }
                    System.out.println(" order up!...");
                    synchronized (restaurant.waitPerson) {
                        restaurant.meal = new Meal(count);
                        restaurant.waitPerson.notifyAll();
                    }
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("chef interrupted");
        }
    }
}
