package Thread.ThreadDemo.suo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by dell on 2017/2/22.
 */
public class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<T>();
    private volatile boolean[] checkOut;
    private Semaphore available;

    public Pool(Class<T> tClass, int size) {
        this.size = size;
        checkOut = new boolean[size];
        available = new Semaphore(size, true);
        for (int i = 0; i < size; i++) {
            try {
                items.add(tClass.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 观察是否可被使用，不能被使用则等待许可
     * 跟踪被签出的对象
     *
     * @return
     * @throws InterruptedException
     */
    public T checkOut() throws InterruptedException {
        available.acquire();
        return getItem();
    }

    /**
     * 释放许可
     * @param x
     */
    public void checkIn(T x) {
        if (releaseItem(x)) {
            available.release();
        }
    }


    //看状态量，将其签出
    public synchronized T getItem() {
        for (int i = 0; i < size; i++) {
            if (!checkOut[i]) {
                checkOut[i] = true;
                return items.get(i);
            }
        }
        return null;
    }

    //修改是否可被签出
    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        if (index == -1) return false;
        if (checkOut[index]) {
            checkOut[index] = false;
            return true;
        }
        return false;
    }
}
