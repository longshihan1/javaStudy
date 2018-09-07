package Thread.ThreadDemo;

/**
 * Created by dell on 2017/2/17.
 */
public class InnerThread1 {
    private int countDown=5;
    private Inner inner;
    private class Inner extends Thread{
        Inner(String name){
            super(name);
            start();
        }

        @Override
        public void run() {
            while (true){
                System.out.println(this);
                if (--countDown==0) return;
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String toString() {
            return getName()+":"+countDown;
        }
    }

    InnerThread1(String name){
        inner=new Inner(name);
    }
}
