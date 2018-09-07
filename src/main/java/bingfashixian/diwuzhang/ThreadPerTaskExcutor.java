package bingfashixian.diwuzhang;

/**
 * 启动线程
 * Created by dell on 2017/3/7.
 */
public class ThreadPerTaskExcutor implements Executor {
    @Override
    public void executr(Runnable command) {
        new Thread(command).start();
    }
}
