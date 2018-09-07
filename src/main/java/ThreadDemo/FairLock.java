package ThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 * Created by dell on 2017/2/24.
 */
public class FairLock implements Runnable {
    public static ReentrantLock fairLoak = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                fairLoak.lock();
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            } finally {
                fairLoak.unlock();
            }
        }
    }

    public static void main(String args[]) {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1, "Thread_t1");
        Thread t2 = new Thread(r1, "Thread_t2");
        t1.start();
        t2.start();
    }
}
