package Thread.ThreadDemo;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dell on 2017/3/2.
 */
public class TimeSK {
    static class MyTimerTask1 extends TimerTask {
        public void run() {
            System.out.println("爆炸！！！");
        }
    }
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask1(), 2000,2000);// 两秒后启动任务
    }
}
