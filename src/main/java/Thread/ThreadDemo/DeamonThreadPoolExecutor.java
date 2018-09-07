package Thread.ThreadDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/16.
 */
public class DeamonThreadPoolExecutor extends ThreadPoolExecutor {
    public DeamonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),new DaemonThreadFactory());
    }
}
