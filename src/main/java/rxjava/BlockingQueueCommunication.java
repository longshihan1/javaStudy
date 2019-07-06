package rxjava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueCommunication {
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }
            }
        }).start();
        //主线程外部循环
        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }

    //业务类
    static class Business {
        BlockingQueue<Integer> sub_quene = new ArrayBlockingQueue<Integer>(1);
        BlockingQueue<Integer> main_quene = new ArrayBlockingQueue<Integer>(1);

        {
            //为了让子队列先走，所以在一开始就往主队列中存入一个对象，使其阻塞。
            try {
                main_quene.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //子队列先走
        public void sub(int i) {
            try {
                sub_quene.put(1);   //子队列第一次存入，可以执行，但由于只有1个空间，已经存满，所以只有在执行后要等到take之后才能继续下次执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //子队列循环执行
            for (int j = 1; j <= 2; j++) {
                System.out.println("sub thread sequence of" + i + ",loop of " + j);
            }
            try {
                main_quene.take();  //让主队列从已经填满的队列中取出数据，使其开始第一次执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void main(int i) {
            try {
                main_quene.put(1);  //主队列先前放过1个空间，现在处于阻塞状态，等待子队列通知，即子线程中的main_quene.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//主队列循环执行
            for (int j = 1; j <= 3; j++) {
                System.out.println("main thread sequence of" + i + ", loop of " + j);
            }
            try {
                sub_quene.take(); //让子队列从已经填满的队列中取出数据，使其执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
