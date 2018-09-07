package Thread.ThreadDemo.suo;/*
package Thread.ThreadDemo.suo;

import javax.annotation.Generated;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

*/
/**
 * Created by dell on 2017/2/23.
 *//*

public abstract class Tester<T> {
    static int testReps=10;
    static int testCycles=1000;
    static int containerSize=1000;
    abstract C ContainerInitializer();
    C testContainer;
    String testID;
    int nReaders;
    int nWriters;
    volatile long readResult=0;
    volatile long readTime;
    volatile long writeTime;
    CountDownLatch endLatch;
    static ExecutorService exec= Executors.newCachedThreadPool();
    Integer[] writeData;

    public Tester(String testID, int nReaders, int nWriters) {
        this.testID = testID+""+nReaders+"r"+nWriters+"w";
        this.nReaders = nReaders;
        this.nWriters = nWriters;

    }
}
*/
