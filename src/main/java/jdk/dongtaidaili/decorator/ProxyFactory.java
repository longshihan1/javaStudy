package jdk.dongtaidaili.decorator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by dell on 2017/5/2.
 * 提供动态代理实例的静态工厂类
 */
public class ProxyFactory {
    /**
     * @param realSubject ：指定需要代理的真实主题类的实例
     * @return proxy ：代理的实例
     */
    public static AbstractSubject getProxy(AbstractSubject realSubject) {

        // 获得被代理类的类加载器，使得JVM能够加载并找到被代理类的内部结构，以及已实现的interface
        ClassLoader loader = realSubject.getClass().getClassLoader();

        // 获得被代理类已实现的所有接口interface,使得动态代理类的实例
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();

        // 用被代理类的实例创建动态代理类的实例，用于真正调用处理程序
        InvocationHandler handler = new DynamicProxy(realSubject);

        /*
         * 使用java.lang.reflect.Proxy类中的静态方法newProxyInstance()获得代理的实例
         *
         * loader : 被代理类的类加载器 interfaces ：被代理类已实现的所有接口，而这些是动态代理类要实现的接口列表 handler
         * ： 用被代理类的实例创建动态代理类的实例，用于真正调用处理程序
         *
         * return ：返回实现了被代理类所实现的所有接口的Object对象，即动态代理，需要强制转型
         */
        AbstractSubject proxy = (AbstractSubject) Proxy.newProxyInstance(
                loader, interfaces, handler);

        return proxy;
    }
}
