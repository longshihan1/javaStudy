package bingfashixian.sanduixianggongxiang;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by dell on 2017/3/3.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number=0;
    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
            }
            System.out.println(" "+number);
        }
    }

    public static void main(String args[]) {

        new ReaderThread().start();
        number=42;
        ready=true;

    }

   /* private static ThreadLocal<Connection> connectionHolder
            =new ThreadLocal<Connection>(){
        public Connection initValue(){
            return DriverManager.getConnection(DB_URL);
        }
    };

    public static Connection getConnectio(){
        return connectionHolder.get();
    }*/

}
