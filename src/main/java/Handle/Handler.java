package Handle;

/**
 * Created by longshihan on 2016/12/11.
 */
public class Handler {
    private MessageQueue mQueue;
    private Looper mLooper;

    //Handler的初始化，在主线程中完成
    public Handler() {
        //获取主线程的Looer对象,取出一个loop和queue
        mLooper = Looper.myLooper();
        this.mQueue = mLooper.mQueue;
    }

    /**
     *
     *发送消息，压入队列
     * @param msg
     */
    public void sendMessage(Message msg) {
        msg.target = this;
        mQueue.enqueueMessage(msg);
    }

    /**
     * 具体处理
     * @param msg
     */
    public void handleMessage(Message msg) {


    }

    /**
     * 转发到处理
     * @param msg
     */
    public void dispatchMessage(Message msg) {
        handleMessage(msg);


    }
}
