package jdk.dongtaidaili.decorator;

/**
 * Created by dell on 2017/5/2.
 */
public class Client {
    public static void main(String[] args) {
        // 被代理类的实例
        AbstractSubject proxy1 = new RealSubject();
        // 通过静态工厂获取动态代理的实例
        AbstractSubject proxy = ProxyFactory.getProxy(proxy1);
        // 装饰之前打印出该代理实例的名称
        System.out.println("装饰前：" + proxy.getClass().getName());
        // 装饰前使用代理实例进行原始操作
        //proxy.request();
        System.out.println("\n第一次装饰之后的效果如下：");
        proxy = new ConcreteDecorator01(proxy);
        System.out.println("\n名称：" + proxy.getClass().getName());
        //proxy.request();

        System.out.println("\n第二次装饰之后的效果如下：");
        proxy = new ConcreteDecorator02(proxy);
        System.out.println("\n名称：" + proxy.getClass().getName());
       // proxy.request();

        System.out.println("\n第三次装饰之后的效果如下：");
        proxy = new ConcreteDecorator03(proxy);
        System.out.println("\n名称：" + proxy.getClass().getName());
        proxy.request();
    }
}
