package Thread.ThreadDemo.DelayQueue;/*
package Thread.ThreadDemo.DelayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

*/
/**
 * Created by dell on 2017/2/22.
 *//*

public class DelayedTask implements Runnable,Delayed {
    private static int counter=0;
    private final int id=counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequene=new ArrayList<>();

    public DelayedTask(int delta) {
        this.delta = delta;
        trigger=System.nanoTime()+NANOSEND
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    @Override
    public void run() {

    }
}
*/
