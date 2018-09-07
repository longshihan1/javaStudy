package Thread.ThreadDemo.bingxingtusuanfa.bussessproduct.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 启动
 * Created by dell on 2017/2/27.
 */
public class TestDisruptor {
    public static void main(String args[]) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        PCDataFactory factory = new PCDataFactory();
        int bufferSize = 1024;
        Disruptor<PCData> dataDisruptor = new Disruptor<PCData>(
                factory, bufferSize, exec, ProducerType.MULTI, new BlockingWaitStrategy()
        );
        dataDisruptor.handleEventsWithWorkerPool(new Consumer(), new Consumer()
                , new Consumer(), new Consumer());
        dataDisruptor.start();

        RingBuffer<PCData> ringBuffer=dataDisruptor.getRingBuffer();
        Producer producer=new Producer(ringBuffer);
        ByteBuffer bb=ByteBuffer.allocate(8);
        for (long i = 0;i<10; i++) {
            bb.putLong(0,i);
            producer.pushData(bb);
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("add data "+i);
        }
    }
}
