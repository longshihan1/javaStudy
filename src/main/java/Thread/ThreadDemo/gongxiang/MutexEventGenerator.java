package Thread.ThreadDemo.gongxiang;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2017/2/17.
 */
public class MutexEventGenerator extends IntGenerator {
    private int currentEventValue=0;
    private Lock lock=new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEventValue;
            Thread.yield();
            ++currentEventValue;
            return currentEventValue;
        }finally {
            lock.unlock();
        }

    }
}
