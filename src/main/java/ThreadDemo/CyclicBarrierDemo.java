package ThreadDemo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 可重用的计数器
 * Created by dell on 2017/2/24.
 */
public class CyclicBarrierDemo {
    public static class Soldier implements Runnable {
        private String solider;
        private final CyclicBarrier cyclicBarrier;

        public Soldier(String solider, CyclicBarrier cyclicBarrier) {
            this.solider = solider;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                //等到所有的士兵到齐
                cyclicBarrier.await();//中断，执行-1，直到=0，才向下跑
                doWork();
                //等待所有士兵完成工作
                cyclicBarrier.await();//在此执行-1，知道=0，向下跑。BarrierRun=true
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            try {
                TimeUnit.MILLISECONDS.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" 任务完成");
        }
    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println(" 司令：[士兵" + N + "个，完成任务！]");
            } else {
                System.out.println(" 司令：[士兵" + N + "个，集合完毕！]");
                flag = true;
            }
        }
    }

    public static void main(String args[]) {
        final int N = 10;
        Thread[] allSoikdier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        //设置障碍点，主要是为了执行这个方法
        System.out.println("集合队伍");
        for (int i = 0; i < N; i++) {
            System.out.println(" 士兵" + i + "报道");
            allSoikdier[i] = new Thread(new Soldier("士兵" + i, cyclicBarrier));
            allSoikdier[i].start();
        }
    }
}
