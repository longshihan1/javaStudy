package Thread.ThreadDemo.AtomicRefer;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by dell on 2017/2/27.
 */
public class AtomicIntegerFieldUpdaterDemo {
    public static class Candidate {
        int id;
        volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdate = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");
    //检查update是否工作
    public static AtomicInteger allScore = new AtomicInteger(0);

    public static void main(String args[]) throws InterruptedException {
        final Candidate stu = new Candidate();
        Thread[] ts = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            ts[i] = new Thread() {
                @Override
                public void run() {
                    if (Math.random() > 0.4) {
                        scoreUpdate.incrementAndGet(stu);
                        allScore.incrementAndGet();
                    }
                }
            };
            ts[i].start();
        }
        for (int i = 0; i < 10000; i++) {
            ts[i].join();
        }
        System.out.println("score= " + stu.score);
        System.out.println(" allscore =" + allScore);
    }
}
