package Thread.ThreadDemo.bingxingtusuanfa.future.jdk;

import java.util.concurrent.*;

/**
 * Created by dell on 2017/2/28.
 */
public class FutureMain {
    public static void main(String args[]) throws ExecutionException, InterruptedException {

        //构造FutureTask
        FutureTask<String> future = new FutureTask<String>(new RealData("a"));
        ExecutorService exec = Executors.newCachedThreadPool();
        //执行futuretask,相当于上面的client.request发起请求
        //在这里执行开启线程realdata的call执行
        exec.submit(future);
        System.out.println("请求完毕");
        try {
            //执行任务
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //相当于data.getResult，获取call方法返回值
        //如果没有执行完，依然会等待
        System.out.println("数据=" + future.get());

    }
}
