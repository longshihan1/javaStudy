package jdk.adapter.classadapter;

/**
 * Created by dell on 2017/5/2.
 * 适配器类，继承了被适配类，同时实现标准接口
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.specificRequest();
    }
}
