package Thread.ThreadDemo;

/**
 * Created by dell on 2017/2/17.
 */
public class Joiner extends Thread{

    private Sleeper sleeper;
    Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper=sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName()+"join completed");
    }
}
