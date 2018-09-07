package Handle;

import java.util.UUID;

/**
 * Created by longshihan on 2016/12/11.
 */
public class HandlerTest {

    public static void main(String args[]) {
        //轮询器准备
        Looper.prepare();

        //主线程
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                System.out.println(Thread.currentThread().getName() + ",received:" + msg.toString());
            }

        };

        //子线程
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        Message msg = new Message();
                        msg.what = 1;
                        synchronized (UUID.class) {
                            msg.obj = Thread.currentThread().getName() + ",send message:" + UUID.randomUUID();
                        }
                        System.out.println(msg);
                        handler.sendMessage(msg);
                        try {
                            Thread.sleep(1000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }.start();
        }


        //开启轮询
        Looper.loop();


    }
}
