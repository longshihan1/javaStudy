package Thread.ThreadDemo.volat;

import java.util.Objects;

/**
 * Created by dell on 2017/2/20.
 */
public class DualSynch {
    private Object syncObject=new Object();
    public synchronized void f(){
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g(){
        synchronized (syncObject){
            for (int i = 0; i < 5; i++) {
                System.out.println(" G()");
                Thread.yield();
            }
        }
    }
}
