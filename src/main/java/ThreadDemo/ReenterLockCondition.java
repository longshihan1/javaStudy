package ThreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *Condition 条件
 * Created by dell on 2017/2/24.
 */
public class ReenterLockCondition implements Runnable {
    public static ReentrantLock fairLoak = new ReentrantLock();
    public static Condition condition = fairLoak.newCondition();

    @Override
    public void run() {
        while (true) {
            try {
                fairLoak.lock();
                condition.await();
                System.out.println("Thread is going on");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                fairLoak.unlock();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ReenterLockCondition r1 = new ReenterLockCondition();
        Thread t1 = new Thread(r1, "Thread_t1");
        t1.start();
        Thread.sleep(2000);
        //通知t1继续
        fairLoak.lock();
        condition.signal();
        fairLoak.unlock();
    }
}
