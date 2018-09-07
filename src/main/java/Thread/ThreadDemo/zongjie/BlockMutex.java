package Thread.ThreadDemo.zongjie;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2017/2/20.
 */
public class BlockMutex {
    private Lock lock=new ReentrantLock();
    public BlockMutex(){
        lock.lock();
    }


}
