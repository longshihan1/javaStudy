package Thread.ThreadDemo.gun;

import sun.misc.Unsafe;

import java.io.IOException;

/**
 * Created by dell on 2017/2/17.
 */
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String args[]) throws IOException {
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
