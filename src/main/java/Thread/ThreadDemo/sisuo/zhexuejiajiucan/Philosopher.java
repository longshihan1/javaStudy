package Thread.ThreadDemo.sisuo.zhexuejiajiucan;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/22.
 */
public class Philosopher implements Runnable {
    private Chopstick left,right;
    private final int id,ponderFactor;
    private Random random=new Random(47);
    private void pause() throws InterruptedException {
        if (ponderFactor==0) return;
        TimeUnit.MILLISECONDS.sleep(ponderFactor*250);
    }

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                System.out.println(this+" "+"thinking");
                pause();

                System.out.println(this+" "+"grabbing right");
                right.take();

                System.out.println(this+" "+"grabbing left");
                left.take();

                System.out.println(this+" "+"eating");
                pause();
                right.drop();
                left.drop();

            }
        }catch(InterruptedException e){
            System.out.printf(e+" InterruptedException");
        }
    }

    @Override
    public String toString() {
        return "Philosopher "+id;
    }
}
