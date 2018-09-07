package ThreadDemo;

/**
 *
 * Created by dell on 2017/2/23.
 */
public class PlusTask {
    static volatile int i=0;
    public static  class PlusTasks implements Runnable{


        @Override
        public void run() {
            for (int j = 0; j < 100; j++) {
                i++;
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
    Thread[] threads=new Thread[10];
        for (int j = 0; j < 10; j++) {
            threads[j]=new Thread(new PlusTasks());
            threads[j].start();
        }
        for (int j = 0; j < 10; j++) {
            threads[j].join();
        }
        System.out.println(i);
    }
}
