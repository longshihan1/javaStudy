package ltttcode.zhan;

import java.util.Iterator;

/**
 * 实现stack 的pop和push接口 要求：
 * - 1.用基本的数组实现
 * - 2.考虑范型
 * - 3.考虑下同步问题
 * - 4.考虑扩容问题
 * Created by dell on 2017/3/9.
 */
public class TestStack<T> implements Iterator<T> {
    private T[] start = (T[]) new Object[1];
    private int N;

    public TestStack() {
        N = 0;
    }

    public void push(T t) {
        if (N == start.length) reSize(2 * start.length);
        start[N++] = t;
    }

    public T pop() {
        T t = start[--N];
        start[N++] = null;
        if (N < start.length / 4) reSize(start.length / 3);//压缩空间，提高使用率
        return t;
    }

    private void reSize(int i) {
        //重定位数组
        T[] ts = (T[]) new Object[i];
        for (int j = 0; j < start.length; j++) {
            ts[j] = start[j];
        }
        start = ts;
    }

    public int getSize() {
        return N;
    }

    @Override
    public boolean hasNext() {
        if (N != start.length && N != 0) {
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        return start[--N];
    }
}
