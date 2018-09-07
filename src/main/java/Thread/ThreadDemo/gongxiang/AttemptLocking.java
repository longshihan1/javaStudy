package Thread.ThreadDemo.gongxiang;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2017/2/17.
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("trylock :" + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("trylock2: " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }

    }

    public static void main(String args[]) {
        final AttemptLocking attemptLocking = new AttemptLocking();
        attemptLocking.untimed();
        attemptLocking.timed();
        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                attemptLocking.lock.lock();
                System.out.println("acquire");
            }
        }.start();
        Thread.yield();
        attemptLocking.untimed();
        attemptLocking.timed();
    }
}
