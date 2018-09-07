package Thread.ThreadDemo.Schedule;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/22.
 */
public class GreenhouseScheduler {
    private volatile boolean light=false;
    private volatile boolean water=false;
    private String thermostat="DAY";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String thermostat) {
        this.thermostat = thermostat;
    }
    ScheduledExecutorService schedular=new ScheduledThreadPoolExecutor(10);
    public void scedule(Runnable event,long delay){
        schedular.schedule(event,delay, TimeUnit.MILLISECONDS);
    }
    public void repeat(Runnable event,long delay ,long period){
        schedular.scheduleAtFixedRate(event,delay,period,TimeUnit.MILLISECONDS);
    }



}
