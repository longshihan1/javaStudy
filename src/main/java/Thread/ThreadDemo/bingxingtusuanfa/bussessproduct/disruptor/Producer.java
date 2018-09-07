package Thread.ThreadDemo.bingxingtusuanfa.bussessproduct.disruptor;

import com.lmax.disruptor.RingBuffer;

/**
 * 生成者
 * Created by dell on 2017/2/27.
 */
public class Producer {

    private final RingBuffer<PCData> ringBuffer;//引用，环形缓冲区

    public Producer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }
    public void pushData(java.nio.ByteBuffer bb){
        long sequence=ringBuffer.next();//获取一个可用的序列号
        try {
            PCData event=ringBuffer.get(sequence);
            event.setValue(bb.getLong(0));
        }finally {
            ringBuffer.publish(sequence);
        }

    }
}
