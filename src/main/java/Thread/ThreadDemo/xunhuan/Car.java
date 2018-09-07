package Thread.ThreadDemo.xunhuan;

/**
 * Created by dell on 2017/2/20.
 */
public class Car {
    private boolean waxOn=false;
    public synchronized void waxed(){
        waxOn=true;
        notifyAll();
    }

    public synchronized void buffed(){
        waxOn=false;
        notifyAll();
    }

    public synchronized void waitForBuffer() throws InterruptedException{
       while (waxOn==false){
           wait();
       }
        waxOn=true;
        notifyAll();
    }

}
