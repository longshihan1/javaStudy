package ThreadDemo;

import java.util.concurrent.*;

/**
 * 测试线程池的报错信息
 * Created by dell on 2017/2/24.
 */
public class DivTask implements Runnable {

    int a, b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a / b;
        System.out.println(" " + re);
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
       /* ThreadPoolExecutor pools = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>());*/
        ThreadPoolExecutor pools = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
           /*Future re= pools.submit(new DivTask(100, i));
            re.get();*/
            pools.execute(new DivTask(100,i));
        }
    }
}
