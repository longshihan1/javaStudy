package bingfashixian.diwuzhang;

import java.util.Map;
import java.util.concurrent.*;

/**
 *use ConcurrentHashMap has 检查更新,
 * Created by dell on 2017/3/6.
 */
public class Momoizer<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

    private final Computable<A, V> c;

    public Momoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = () -> c.compute(arg);
                FutureTask<V> ft = new FutureTask<V>(eval);
                f = cache.putIfAbsent(arg,ft);
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
}
