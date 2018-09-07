package Thread.ThreadDemo.blockingqueue;/*
package Thread.ThreadDemo.blockingqueue;

import Thread.ThreadDemo.LiftOff;

import java.util.concurrent.BlockingQueue;

*/
/**
 * Created by dell on 2017/2/21.
 *//*

public class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff lo){
        rockets.add(lo);

    }
    @Override
    public void run() {
        while (!Thread.interrupted()){
            LiftOff rocket=rockets.take();
            rocket.run();
        }
    }
}
*/
