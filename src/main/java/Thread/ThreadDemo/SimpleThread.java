package Thread.ThreadDemo;

/**
 * Created by dell on 2017/2/17.
 */
public class SimpleThread implements Runnable{

    private int countDown=5;
    private static int threadCount=0;
    private Thread t=new Thread(this);
    SimpleThread(){
       t.start();
    }

    @Override
    public void run() {

    }
}
