package Thread.ThreadDemo.zongjie;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dell on 2017/2/20.
 */
public class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read():");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from IO ");
            } else {
                throw new RuntimeException(e);
            }

        }
        System.out.println("Exiting IOBlocked");
    }
}
