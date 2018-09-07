package Thread.ThreadDemo.bingxingtusuanfa.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

/**
 * Created by dell on 2017/2/28.
 */
public class HandleMsg implements Runnable {
    SelectionKey sk;
    ByteBuffer bb;

    public HandleMsg(SelectionKey sk, ByteBuffer bb) {
        this.bb=bb;
        this.sk=sk;
    }

    @Override
    public void run() {
        EchoClient echoClient= (EchoClient) sk.attachment();
        echoClient.enqueue(bb);
        sk.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);
        //强迫selector立即返回
        
    }
}
