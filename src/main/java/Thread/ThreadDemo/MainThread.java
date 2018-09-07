package Thread.ThreadDemo;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by dell on 2017/2/15.
 */
public class MainThread {

    public static void main(String args[]) throws InterruptedException {

       /* ExecutorService exec= Executors.newSingleThreadExecutor();
        for (int i = 0; i <5; i++) {
//            new Thread(new LiftOff()).start();
            exec.execute(new LiftOff());
        }
        exec.shutdown();
//        LiftOff launch=new LiftOff();
//        launch.run();*/
        ExecutorService exec= Executors.newCachedThreadPool();
        ArrayList<Future<String>> result=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TimeUnit.MILLISECONDS.sleep(1000);
            result.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs:result) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();

            }finally {
                exec.shutdown();
            }

        }

    }
}
