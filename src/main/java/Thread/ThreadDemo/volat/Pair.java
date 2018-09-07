package Thread.ThreadDemo.volat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dell on 2017/2/20.
 */
public class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "x:" + x + ",y:" + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }

    abstract class PairManager {
        AtomicInteger checkCount = new AtomicInteger(0);
        protected Pair p = new Pair();
        private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

        public synchronized Pair getPair() {
            return new Pair(p.getX(), p.getY());
        }

        protected void store(Pair p) {
            storage.add(p);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public abstract void increment();
    }

     class PairManager1 extends PairManager {

        @Override
        public synchronized void increment() {
            p.incrementX();
            p.incrementY();
            store(p);
        }
    }

    class PairManager2 extends PairManager {

        @Override
        public void increment() {
            Pair pair;
            synchronized (this) {
                p.incrementX();
                p.incrementY();
                pair = p;
            }
            store(pair);
        }
    }

    static class PairManipulator implements Runnable {

        private PairManager pm;

        public PairManipulator(PairManager pm) {
            this.pm = pm;
        }

        @Override
        public void run() {
            while (true) {
                pm.increment();
            }
        }

        @Override
        public String toString() {
            return "pair :" + pm.getPair() + "checkCount=" + pm.checkCount.get();
        }
    }

    static class PairChecker implements Runnable {


        private PairManager pm;

        public PairChecker(PairManager pm) {
            this.pm = pm;
        }

        @Override
        public void run() {
            while (true) {
                pm.checkCount.incrementAndGet();
                pm.getPair().checkState();
            }
        }
    }


}
