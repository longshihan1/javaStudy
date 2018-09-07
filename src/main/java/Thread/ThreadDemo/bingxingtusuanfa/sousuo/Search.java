package Thread.ThreadDemo.bingxingtusuanfa.sousuo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 粒子搜索
 * Created by dell on 2017/2/28.
 */
public class Search {
    static int[] arr;
    static ExecutorService pool = Executors.newCachedThreadPool();
    static AtomicInteger result = new AtomicInteger(-1);
    final static int Thread_num=2;

    public static int search(int searchValue, int beginPos, int endPos) {
        int i;
        for (i = beginPos; i < endPos; i++) {
            if (result.get() >= 0) {
                return result.get();
            }
            if (arr[i] == searchValue) {
                //如果设置失败，表示其他线程已经找到
                if (!result.compareAndSet(-1, i)) {
                    return result.get();
                }
                return i;
            }
        }
        return -1;
    }
}
