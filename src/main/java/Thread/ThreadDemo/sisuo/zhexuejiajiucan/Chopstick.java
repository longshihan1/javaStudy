package Thread.ThreadDemo.sisuo.zhexuejiajiucan;

/**
 * Created by dell on 2017/2/22.
 */
public class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
