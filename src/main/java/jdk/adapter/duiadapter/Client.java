package jdk.adapter.duiadapter;

import jdk.adapter.classadapter.Adaptee;
import jdk.adapter.classadapter.ConcreteTarget;
import jdk.adapter.classadapter.Target;

/**
 * Created by dell on 2017/5/2.
 */
public class Client {
    public static void main(String[] args) {
        // 使用普通功能类
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        // 使用特殊功能类，即适配类，
        // 需要先创建一个被适配类的对象作为参数
        Target adapter = new Adapter(new Adaptee());
        adapter.request();
    }
}
