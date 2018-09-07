package Thread.ThreadDemo.volat;

/**
 * Created by dell on 2017/2/20.
 */
public class SyncObject {
    public static void main(String args[]) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            @Override
            public void run() {
                ds.f();
            }
        }.run();
        ds.g();
    }
}
