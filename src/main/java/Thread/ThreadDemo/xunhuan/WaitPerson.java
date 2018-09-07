package Thread.ThreadDemo.xunhuan;

/**
 * Created by dell on 2017/2/21.
 */
public class WaitPerson implements Runnable {
    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    private Restaurant restaurant;

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                    System.out.println("Waitperson got" + restaurant.meal);
                    synchronized (restaurant.chef) {
                        restaurant.meal = null;
                        restaurant.chef.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(" waitperson in InterruptedException");
        }
    }
}
