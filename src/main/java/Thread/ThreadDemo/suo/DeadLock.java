package Thread.ThreadDemo.suo;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;


/**
 * Created by dell on 2017/2/27.
 */
public class DeadLock extends Thread {
    protected Object tool;
    static Object fork1 = new Object();
    static Object fork2 = new Object();

    public DeadLock(Object tool) {
        this.tool = tool;
        if (tool == fork1) {
            this.setName("哲学家A");
        }

        if (tool == fork2) {
            this.setName("哲学家B");
        }

    }

    @Override
    public void run() {
        if (tool == fork1) {
            synchronized (fork1) {
                try {
                    MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fork2) {
                    System.out.println("哲学家A开始吃饭");
                }
            }
        }
        if (tool == fork2) {
            synchronized (fork2) {
                try {
                    MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fork1) {
                    System.out.println("哲学家B开始吃饭");
                }
            }
        }
    }

    public static void main(String args[]) {
        DeadLock zhea = new DeadLock(fork1);
        DeadLock zhab = new DeadLock(fork2);
        zhea.start();
        zhab.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
