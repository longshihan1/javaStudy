package bingfashixian.diwuzhang;

/**
 * 同步的方式执行任务
 * Created by dell on 2017/3/7.
 */
public class WithinThreadExecutor implements Executor {
    @Override
    public void executr(Runnable command) {
        command.run();
    }
}
