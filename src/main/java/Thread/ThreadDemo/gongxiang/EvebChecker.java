package Thread.ThreadDemo.gongxiang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dell on 2017/2/17.
 */
public class EvebChecker implements Runnable {
    private IntGenerator generator;
    private final int id;
    EvebChecker(IntGenerator g,int ident){
        generator=g;
        id=ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val=generator.next();
            if (val%2!=0){
                System.out.println(val+" not event!");
                generator.cancel();
            }
        }
    }
    public static void test(IntGenerator gp,int count){
        System.out.println("press cc to exit");
        ExecutorService exec= Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvebChecker(gp,i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
