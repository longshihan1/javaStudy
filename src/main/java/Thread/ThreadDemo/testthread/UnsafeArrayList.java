package Thread.ThreadDemo.testthread;

import Thread.ThreadDemo.jdk.future.AskThread;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/3/2.
 */
public class UnsafeArrayList {
    static ArrayList al = new ArrayList();

    static class AddTask implements Runnable {

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {

            }
            for (int i = 0; i < 10000; i++) {
                al.add(new Object());
            }
        }
    }


    public static void main(String args[]) {
        Thread t1 = new Thread(new AddTask(), "t1");
        Thread t2 = new Thread(new AddTask(), "t2");
        t1.start();
        t2.start();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t3");
        t3.start();
    }
}
