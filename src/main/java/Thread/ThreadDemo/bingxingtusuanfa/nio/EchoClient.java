package Thread.ThreadDemo.bingxingtusuanfa.nio;

import java.nio.ByteBuffer;
import java.util.LinkedList;

/**
 * Created by dell on 2017/2/28.
 */
public class EchoClient {
    private LinkedList<ByteBuffer> outq;

    EchoClient() {
        outq = new LinkedList<>();
    }

    public LinkedList<ByteBuffer> getOutq() {
        return outq;
    }

    public void enqueue(ByteBuffer byteBuffer) {
        outq.addFirst(byteBuffer);
    }
}
