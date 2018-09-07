package Thread.ThreadDemo.bingxingtusuanfa.bussessproduct.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * 消费者
 * Created by dell on 2017/2/27.
 */
public class Consumer implements WorkHandler<PCData> {

    @Override
    public void onEvent(PCData pcData) throws Exception {
        System.out.println(Thread.currentThread().getId() + " :Event:---" + pcData.getValue() * pcData.getValue() + "----");
    }
}
