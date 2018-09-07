package Thread.ThreadDemo;

import java.util.concurrent.ThreadFactory;

/**
 * Created by dell on 2017/2/16.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread=new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
