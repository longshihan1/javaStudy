package jdk.dongtaidaili.decorator;

/**
 * Created by dell on 2017/5/2.
 * 抽象装饰类，一定要以自己的父类、父接口为一个属性
 */
public class Decorator implements AbstractSubject {
    protected AbstractSubject subject = null;

    public Decorator(AbstractSubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {

    }
}
