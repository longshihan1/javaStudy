package Thread.ThreadDemo;

/**
 * Created by dell on 2017/2/17.
 */
public class Sleeper extends Thread {

    private int duration;
    Sleeper(String name,int sleepTime){
        super(name);
        duration=sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        }catch (Exception e){
            System.out.println(getName()+"was interrupted is Interrupted:"+isInterrupted());
            return;
        }
        System.out.println(getName()+" has awakened");
    }
}
