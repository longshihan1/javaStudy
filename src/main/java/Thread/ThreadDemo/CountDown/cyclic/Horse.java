package Thread.ThreadDemo.CountDown.cyclic;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by dell on 2017/2/22.
 */
public class Horse implements Runnable {
    private static int count=0;
    private final int id=count++;
    private int strides=0;
    private static Random rand=new Random(47);
    private final CyclicBarrier barrier;

    public synchronized int getStrides() {
        return strides;
    }

    public Horse(CyclicBarrier barrier) {
        this.barrier = barrier;
    }



    @Override
    public void run() {
        try{

            while (!Thread.interrupted()){
                synchronized (this){
                    strides+=rand.nextInt(3);
                }
                barrier.await();
            }
        }catch(InterruptedException e){
            //System.out.println(e+" InterruptedException");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public String toString() {
        return "horse "+id+"";
    }
    
    public String tracks(){
        StringBuilder s=new StringBuilder();
        for (int i = 0; i <getStrides(); i++) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}
