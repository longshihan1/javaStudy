package Thread.ThreadDemo.suo;

/**
 * Created by dell on 2017/2/23.
 */
public class Fat {
    private volatile double d;
    private static int count = 0;
    private final int id = count++;

    private Fat() {
        for (int i = 0; i < 10000; i++) {
            d += (Math.PI + Math.E) / (double) i;
        }
    }

    public void operation() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "FAT id " + id;
    }
}
