package ThreadDemo;

import java.util.concurrent.*;

/**
 * 线程池的使用
 * Created by dell on 2017/2/24.
 */
public class RejectThreadPoolDemo {

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + " :Thread ID" + Thread.currentThread().getId());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        MyTask task = new MyTask();
       /* ExecutorService exec = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10), Executors.defaultThreadFactory(),
                (r, executor) -> System.out.println(r.toString() + " is discard"));
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            exec.submit(task);
            TimeUnit.MILLISECONDS.sleep(10);
        }*/
        ExecutorService exec = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
            }
        };

    }
}
