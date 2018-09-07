package Thread.ThreadDemo.blockingqueue.pipe;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/21.
 */
public class Sender implements Runnable {
    private Random random = new Random(47);
    private PipedWriter out = new PipedWriter();

    public PipedWriter getOut() {
        return out;
    }


    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));

                }
            }
        } catch (IOException e) {
            System.out.println(e+" Sender");
        }catch (InterruptedException e) {
            System.out.println(e+" Sender sleep InterruptedException");
        }
    }
}
