package bingfashixian.diwuzhang;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/3/7.
 */
public interface ExecutorService extends Executor {
   void shutdown();
    List<Runnable> shutdownNow();
    boolean isShutdown();
    boolean isTerminated();
    boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;
    //其他方法
}
