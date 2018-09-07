package jdk.dongtaidaili.strongproxy;

/**
 * Created by dell on 2017/5/2.
 */
public class RealSubject02 extends Subject02 {
    private Subject02 proxy = null;

    //被代理者明白自己需要被代理，于是将自己this作为参数找到自己的代理
    public RealSubject02() {
        this.proxy = new Proxy03(this);
    }

    public void request() {
        System.out.println("被代理者的 request() ...");
    }

    public Subject02 getProxy() {
        return this.proxy;
    }
}
