package bingfashixian.diwuzhang;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * hashmap实现缓存，但compute是锁阻塞状态，每次只有一个能进入，
 * 如果执行时间过长，效果并不好。
 * Created by dell on 2017/3/6.
 */
public class Memoizer1<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new HashMap<A, V>();

    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
