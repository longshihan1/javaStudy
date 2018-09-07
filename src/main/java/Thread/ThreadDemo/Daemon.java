package Thread.ThreadDemo;

import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/16.
 */
public class Daemon implements Runnable {
    private Thread[] t=new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i]=new Thread(new DaemonSpawn());
        }
    }

    class DaemonSpawn implements Runnable{

        @Override
        public void run() {
            while (true){
                Thread.yield();
            }
        }
    }


}
