package jdk.dongtaidaili.decorator;

/**
 * Created by dell on 2017/5/2.
 * 真实主题类，即被代理类
 */
public class RealSubject implements AbstractSubject {
    public void request() {
        System.out.println("真实的方法-----RealSubject's request() ...");
    }
}
