package Thread.ThreadDemo.bingxingtusuanfa.juzhen;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by dell on 2017/2/28.
 */
public class TestRecuriveAction {
    static ForkJoinPool forkJoinPool = new ForkJoinPool();

    public static void main(String args[]) {
        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(244);
        forkJoinPool.invoke(myRecursiveAction);
    }
}
