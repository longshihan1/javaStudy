package Thread.ThreadDemo.blockingqueue;

/**
 * Created by dell on 2017/2/21.
 */
public class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int count=0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                Toast t=finishedQueue.take();
             if (t.getId()!=count++||t.getStatus()!=Toast.Status.JAMMED){
                 System.out.println(">>> Error"+t);
                 System.exit(1);
             }else {
                 System.out.println("Chomp"+t);

             }
            }
        }catch (InterruptedException e){
            System.out.println("Easter InterruptedException");
        }
        System.out.println("Easter OFf");
    }
}
