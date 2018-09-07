package bingfashixian.diwuzhang;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 在后台等待线程跑完,but if is not atomic
 * Created by dell on 2017/3/6.
 */
public class Momoizer3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

    private final Computable<A, V> c;

    public Momoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = () -> c.compute(arg);
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run();//在这里调用c.compute
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            return null;
        }
    }
}
