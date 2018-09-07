package Thread.ThreadDemo.yichang;

import java.util.concurrent.ThreadFactory;

/**
 * Created by dell on 2017/2/17.
 */
public class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this+"create new thread ");
        Thread t=new Thread(r);
        System.out.println("created "+t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh ="+t.getUncaughtExceptionHandler());
        return t;
    }
}
