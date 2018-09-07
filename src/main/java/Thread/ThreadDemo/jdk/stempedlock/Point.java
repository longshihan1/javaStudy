package Thread.ThreadDemo.jdk.stempedlock;

import java.util.concurrent.locks.StampedLock;

/**
 * Created by dell on 2017/3/1.
 */
public class Point {
    private double x, y;
    private final StampedLock s1 = new StampedLock();//改进的读写锁

    void move(double deltax, double deltaY) {//这是一个排他锁
        long stamp = s1.writeLock();
        try {
            x += deltax;
            y += deltaY;

        } finally {
            s1.unlockWrite(stamp);
        }
    }

    double distanceFromOrigin() {//只读
        long stemp = s1.tryOptimisticRead();
        double currentX = x, currentY = y;
        if (!s1.validate(stemp)) {
            stemp = s1.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                s1.unlockRead(stemp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
