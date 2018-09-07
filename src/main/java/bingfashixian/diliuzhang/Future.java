package bingfashixian.diliuzhang;

import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/3/7.
 */
public interface Future<V> {
    boolean cancel(boolean mayInterruptIfRunning);

    boolean isCancelled();

    boolean isDone();

    V get() throws Exception;

    V get(long timeout, TimeUnit unit) throws Exception;
}
