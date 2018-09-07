package Thread.ThreadDemo.bingxingtusuanfa.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dell on 2017/2/28.
 */
public class MultiThreadEchoServer {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class HandlerMsg implements Runnable {

        Socket socket;

        public HandlerMsg(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader is = null;
            PrintWriter os = null;
            try {
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                os = new PrintWriter(socket.getOutputStream(), true);
                //从inputstream读取客户端发送的数据
                String inputLine = null;
                long b = System.currentTimeMillis();
                while ((inputLine = is.readLine()) != null) {
                    os.println(inputLine);
                }
                long e = System.currentTimeMillis();
                System.out.println("spend: " + (e - b) + "ms");
            } catch (IOException e) {
                System.out.println(e + " InterruptedException");
            } finally {
                try {
                    if (is != null) is.close();
                    if (os != null) os.close();
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e + " InterruptedException");
                }
            }
        }
    }

    public static void main(String args[]) {
        ServerSocket echoServer = null;
        Socket clientSocket = null;
        try {
            echoServer = new ServerSocket(8000);
        } catch (IOException e) {
            System.out.println(e + " InterruptedException");
        }
        while (true) {
            try {
                clientSocket = echoServer.accept();
                System.out.println(clientSocket.getRemoteSocketAddress() + "connection ");
                exec.execute(new HandlerMsg(clientSocket));
            } catch (IOException e) {
                System.out.println(e + " InterruptedException");
            }
        }
    }
}
