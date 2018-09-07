package bingfashixian.diwuzhang;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 基于线程池的Execute
 * Created by dell on 2017/3/7.
 */
public class TaskExcutionWebServer {
    private static final int NTHREADS = 100;
    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String args[]) throws IOException {

        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                   // handlequest(connection);
                }
            };
            exec.execute(task);
        }
    }
}
