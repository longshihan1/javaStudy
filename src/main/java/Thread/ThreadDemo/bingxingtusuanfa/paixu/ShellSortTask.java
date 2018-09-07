package Thread.ThreadDemo.bingxingtusuanfa.paixu;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dell on 2017/2/28.
 */
public class ShellSortTask implements Runnable {
    int i = 0;
    int h = 0;
    CountDownLatch l;
    int[] arr;

    public ShellSortTask(int i, int h, CountDownLatch l) {
        this.i = i;
        this.h = h;
        this.l = l;
    }

    @Override
    public void run() {
        if (arr[i] < arr[i - h]) {
            int temp = arr[i];
            int j = i - h;
            while (j >= 0 && arr[j] > temp) {
                arr[j + h] = arr[j];
                j -= h;
            }
            arr[j + h] = temp;
        }
        l.countDown();
    }
}
