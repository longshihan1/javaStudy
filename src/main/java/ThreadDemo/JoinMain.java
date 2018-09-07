package ThreadDemo;

/**
 * 线程等待执行完
 * Created by dell on 2017/2/23.
 */
public class JoinMain {

    public volatile static int i=0;
    public static class addThread extends Thread{
        @Override
        public void run() {
            for (i = 0; i <10000; i++);
        }
    }
    public static void main(String args[]) throws InterruptedException {
        addThread at=new addThread();
        at.start();
        at.join();
        System.out.println(i);
    }
}
