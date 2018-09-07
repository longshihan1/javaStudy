package Thread.ThreadDemo.yichang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dell on 2017/2/17.
 */
public class CaptureUncaughtException {
    public static void main(String args[]) {
        ExecutorService exec= Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
