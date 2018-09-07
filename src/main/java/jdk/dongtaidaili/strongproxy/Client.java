package jdk.dongtaidaili.strongproxy;

/**
 * Created by dell on 2017/5/2.
 * \装饰器模式下的
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("\n第三种代理：强制代理");
        Subject02 realSubject = new RealSubject02();
        //获得具体被代理者的代理
        Subject02 proxy03 = realSubject.getProxy();
        proxy03.request();
    }
}
