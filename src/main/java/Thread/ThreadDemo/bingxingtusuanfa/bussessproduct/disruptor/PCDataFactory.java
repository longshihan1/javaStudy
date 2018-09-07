package Thread.ThreadDemo.bingxingtusuanfa.bussessproduct.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * 产生pcdata的工厂类
 * Created by dell on 2017/2/27.
 */
public class PCDataFactory implements EventFactory<PCData> {
    @Override
    public PCData newInstance() {
        return new PCData();
    }
}
