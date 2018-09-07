package Thread.ThreadDemo.bingxingtusuanfa.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NIO 下的服务端
 * Created by dell on 2017/2/28.
 */
public class TestNIOServer {
    private static Selector selector;
   static ExecutorService exec = Executors.newCachedThreadPool();
    public static Map<Socket, Long> time_stat = new HashMap<>();

    public static void main(String args[]) throws Exception {
        startServer();
    }

    private static void startServer() throws Exception {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);//设置非阻塞

        InetSocketAddress isa = new InetSocketAddress(InetAddress.getLocalHost(), 8000);
        InetSocketAddress isb = new InetSocketAddress(8000);
        ssc.socket().bind(isa);

        //半
        SelectionKey acceptKey = ssc.register(selector, SelectionKey.OP_ACCEPT);

        for (; ; ) {
            selector.select();//阻塞
            Set readyKey = selector.selectedKeys();
            Iterator i = readyKey.iterator();
            long e = 0;
            while (i.hasNext()) {
                SelectionKey sk = (SelectionKey) i.next();
                i.remove();
                if (sk.isAcceptable()) {
                    doAccept(sk);//接收
                } else if (sk.isValid() && sk.isReadable()) {
                    if (!time_stat.containsKey(((SocketChannel) sk.channel()).socket())) {
                        time_stat.put(((SocketChannel) sk.channel()).socket(), System.currentTimeMillis());
                    }
                    doRead(sk);//读取
                } else if (sk.isValid() && sk.isWritable()) {
                    doWrite(sk);//写入
                    e = System.currentTimeMillis();
                    long b = time_stat.remove(((SocketChannel) sk.channel()).socket());
                    System.out.println("spend： " + (e - b) + "ms");
                }
            }
        }
    }

    private static void doWrite(SelectionKey sk) {

    }

    private static void doRead(SelectionKey sk) {
        SocketChannel channel= (SocketChannel) sk.channel();
        ByteBuffer bb=ByteBuffer.allocate(8192);
        int len;
        try {
            len=channel.read(bb);
            if (len<0){
                disconnect(sk);
                return;
            }
        } catch (IOException e) {
            System.out.println("Failed to read from client ");
            e.printStackTrace();
            disconnect(sk);
            return;
        }
        bb.flip();
        exec.execute(new HandleMsg(sk,bb));
    }

    private static void disconnect(SelectionKey sk) {

    }

    private static void doAccept(SelectionKey sk) {
        ServerSocketChannel server = (ServerSocketChannel) sk.channel();
        SocketChannel clientChannel;
        try {
            clientChannel = server.accept();
            clientChannel.configureBlocking(false);
            SelectionKey clinentKey = clientChannel.register(selector, SelectionKey.OP_ACCEPT);
            EchoClient echoClient = new EchoClient();
            clinentKey.attach(echoClient);

            InetAddress clientAddress = clientChannel.socket().getInetAddress();
            System.out.println("Accept connetion form " + clientAddress.getCanonicalHostName());
        } catch (Exception e) {
            System.out.println(e + "Fail to accept new client");
        }
    }


}
