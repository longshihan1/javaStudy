package rxjava;

import java.util.concurrent.Semaphore;

public class ThreadCommunication {
    private static int num;
    /**
     * 定义一个信号量，该类内部维持了多个线程锁，可以阻塞多个线程，释放多个线程，
     * 线程的阻塞和释放是通过permit 概念来实现的线程通过semaphore.acquire()方法获取permit，
     * 如果当前semaphore 有permit 则分配给该线程，如果没有则阻塞该线程直到semaphore
     * 调用release（）方法释放permit。构造函数中参数：permit（允许） 个数
     */
    private static Semaphore semaphore = new Semaphore(0);
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //模拟耗时操作之后初始化变量num
                    Thread.sleep(1000);
                    num = 1;
                    //初始化完参数后释放两个permit
                    semaphore.release(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取permit，如果semaphore 没有可用的permit 则等待
                    // 如果有则消耗一个
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        +"获取到num 的值为："+num);
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取permit，如果semaphore 没有可用的permit 则等待
                    // 如果有则消耗一个
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        +"获取到num 的值为："+num);
            }
        });
        //同时开启3 个线程
        threadA.start();
        threadB.start();
        threadC.start();
    }
}