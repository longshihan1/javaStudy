package bingfashixian.diwuzhang;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 只是保证了得到的result是唯一的，但方法可以被同时进入，
 * 当线程1在跑，线程2跑同样的数据，会重复计算，
 * Created by dell on 2017/3/6.
 */
public class Momoizer2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();

    private final Computable<A, V> c;

    public Momoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
