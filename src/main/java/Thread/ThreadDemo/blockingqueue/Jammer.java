package Thread.ThreadDemo.blockingqueue;

/**
 * Created by dell on 2017/2/21.
 */
public class Jammer implements Runnable{
    private ToastQueue dryQueue,bufferedQueue;

    public Jammer(ToastQueue dryQueue, ToastQueue bufferedQueue) {
        this.dryQueue = dryQueue;
        this.bufferedQueue = bufferedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t=dryQueue.take();
                t.jam();
                System.out.println(t);
                bufferedQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Jammer InterruptedException");
        }
        System.out.println("Jammer OFf");
    }
}
