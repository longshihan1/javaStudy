package jdk.dongtaidaili.strongproxy;

/**
 * Created by dell on 2017/5/2.
 */
public class Proxy03 extends Subject02 {
    private Subject02 realSubject = null;

    public Proxy03(Subject02 realSubject) {
        this.realSubject = realSubject;
    }

    public void request() {
        System.out.println("代理者的 request() ...");
        this.realSubject.request();
        System.out.println("被代理者操作完成 ...");
    }

    //代理者本身只是返回自己，当然也可以一直扩展下去
    public Subject02 getProxy() {
        return this;
    }
}
