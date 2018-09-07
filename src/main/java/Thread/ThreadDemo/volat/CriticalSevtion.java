package Thread.ThreadDemo.volat;/*
package Thread.ThreadDemo.volat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

*/
/**
 * Created by dell on 2017/2/20.
 *//*

public class CriticalSevtion {
   static void testApproaches(Pair.PairManager pman1, Pair.PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Pair.PairManipulator
                pm1 = new Pair.PairManipulator(pman1),
                pm2 = new Pair.PairManipulator(pman2);
        Pair.PairChecker
                pairChecker1 = new Pair.PairChecker(pman1),
                pairChecker2 = new Pair.PairChecker(pman2);

        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pairChecker1);
        exec.execute(pairChecker2);

        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("pm1:" + pm1 + "\npm2:" + pm2);
        System.exit(0);


    }

    public  void main(String args[]) {
        Pair.PairManager pman1 = new Pair.PairManager1();
        Pair.PairManager pman2 = new Pair.PairManager1();
        testApproaches(pman1, pman2);
    }
}
*/
