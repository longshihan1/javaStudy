package ThreadDemo;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock 读写锁
 * Created by dell on 2017/2/24.
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();//模拟读操作
            TimeUnit.MILLISECONDS.sleep(1000);//读操作越多。读写锁优势明显
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();//模拟写操作
            TimeUnit.MILLISECONDS.sleep(1000);
            value = index;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String args[]) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);
                  //  demo.handleRead(lock);
                } catch (InterruptedException e) {
                    System.out.println(e + " InterruptedException");
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(writeLock, new Random().nextInt());
                  //  demo.handleWrite(lock, new Random().nextInt());
                } catch (InterruptedException e) {
                    System.out.println(e + " InterruptedException");
                }
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(writeRunnable).start();
        }
    }
}
