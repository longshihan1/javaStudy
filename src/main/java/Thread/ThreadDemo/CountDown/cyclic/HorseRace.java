package Thread.ThreadDemo.CountDown.cyclic;/*
package Thread.ThreadDemo.CountDown.cyclic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

*/
/**
 * Created by dell on 2017/2/22.
 *//*

public class HorseRace {
    static final int FINISH_LINE=75;
    private List<Horse> horses=new ArrayList<>();
     ExecutorService exec= Executors.newCachedThreadPool();
    CyclicBarrierDemo barrier;
    HorseRace(int nHorses,final int pause){
        barrier=new CyclicBarrierDemo(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder s=new StringBuilder();
                for (int i = 0; i <FINISH_LINE; i++) {
                    s.append("*");
                }
                s.append(id);
            }
        });
    }
}
*/
