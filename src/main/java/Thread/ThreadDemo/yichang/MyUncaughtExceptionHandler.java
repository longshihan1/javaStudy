package Thread.ThreadDemo.yichang;

/**
 * Created by dell on 2017/2/17.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught"+e);
    }
}
