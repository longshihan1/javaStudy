package Thread.ThreadDemo.zongjie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/20.
 */
public class Entrance implements Runnable {

    private static Count count=new Count();
    private static List<Entrance> entrances=new ArrayList<>();
    private int number=0;
    private final int id;
    private static volatile boolean canceled=false;
    public static  void cancel(){
        canceled=true;
    }
    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled){
            synchronized (this){
                ++number;
            }
        }
        System.out.println(this+"Total:"+count.increment());
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Stoping "+this);
    }

    public synchronized int getvalue(){
        return number;
    }

    @Override
    public String toString() {
        return "Entrance"+id+":"+getvalue();
    }

    public static  int getToalCount(){
        return count.value();
    }

    public static int SumEntrances(){
        int sum=0;
        for (Entrance en:entrances) {
            sum+=en.getvalue();
        }
        return sum;
    }
}
