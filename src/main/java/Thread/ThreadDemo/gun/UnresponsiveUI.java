package Thread.ThreadDemo.gun;

import java.io.IOException;

/**
 * Created by dell on 2017/2/17.
 */
public class UnresponsiveUI {
    private volatile double d=1;
    UnresponsiveUI() throws IOException {
        while (d>0)
            d=d+(Math.PI+Math.E)/d;
        System.in.read();
    }
}
