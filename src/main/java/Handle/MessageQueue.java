package Handle;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by longshihan on 2016/12/11.
 */
public class MessageQueue {

    //通过数组结构存储Message对象
    Message[] items;
    //入队与出队元素索引位置
    int putIndex;
    int takeIndex;
    //计数器
    int count;
    //互斥锁
    /*
    * 代码块加锁
    * sysnchronized(msg){
    *
    * }
    * */
    private Lock lock;

    //条件变量
    private Condition notEmpty;//与当前的重入锁相关联
    private Condition notFull;

    public MessageQueue() {
        //消息队列应该有大小限制
        this.items = new Message[50];
        this.lock = new ReentrantLock();//重入锁，非公平
        this.notEmpty = lock.newCondition();//通知锁为空
        this.notFull = lock.newCondition();//通知锁未满
    }

    /**
     * 加入队列（子线程运行）
     * 生产
     *
     * @param msg
     */
    public void enqueueMessage(Message msg) {
        try {
            lock.lock();
            //消息队列满了，子线程停止发送消息，阻塞
            while (count == items.length) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            items[putIndex] = msg;
            //循环取值
            putIndex = (++putIndex == items.length) ? 0 : putIndex;
            count++;
            //System.out.println("加入队列");
            //生产出来产品，通知
            //有新的message对象通知主线程
            notEmpty.signal();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 出队列（主线程运行）
     * 消费
     *
     * @return
     */
    public Message next() {
        //消息队列为空，主线程Looper停止轮询，阻塞
        Message message = null;
        try {
            lock.lock();
            while (count == 0) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            message = items[takeIndex];//取出
            items[takeIndex] = null;//元素置空
            takeIndex = (++takeIndex == items.length) ? 0 : takeIndex;
            count--;
            //使用了一个message对象，通知主线程，可以继续生产
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return message;
    }
}
