package ThreadDemo;

/**
 * Created by dell on 2017/2/23.
 */
public class ThreadGroupName implements Runnable {
    public static void main(String args[]) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t2 = new Thread(tg, new ThreadGroupName(), "T1");
    }

    @Override
    public void run() {

    }
}
