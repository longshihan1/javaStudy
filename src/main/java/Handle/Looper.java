package Handle;

/**
 * Created by longshihan on 2016/12/11.
 */
public final class Looper {

    //每个主线程都会有Looper对象
    //Looper对象保存在ThreadLocal，保证了线程数据的隔离
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();

    //一个Loop对象，对应一个消息队列
    MessageQueue mQueue;

    private Looper() {
        mQueue = new MessageQueue();
    }

    /**
     * Looper对象的初始化，只运行一次
     */
    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Handle.Looper may be Creater per thread");
        }
        sThreadLocal.set(new Looper());
    }


    /**
     * 获取当前线程的Looper对象
     *
     * @return
     */
    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    /**
     * 轮询消息队列
     */
    public static void loop() {
        Looper me = myLooper();
        if (me == null) {
            throw new RuntimeException("No Handle.Looper;Handle.Looper.prepare() wasnot called on");
        }
        MessageQueue queue = me.mQueue;
        for (; ; ) {
            Message msg = queue.next();
            if (msg == null) {
                continue;
            }
            //转化给Handler
            msg.target.dispatchMessage(msg);
        }
    }
}
