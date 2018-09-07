package bingfashixian.diwuzhang;

/**
 * Created by dell on 2017/3/6.
 */
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
