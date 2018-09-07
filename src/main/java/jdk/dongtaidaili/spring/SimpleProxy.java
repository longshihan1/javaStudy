package jdk.dongtaidaili.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by longshihan on 2017/4/30.
 */
public class SimpleProxy implements InvocationHandler {
    private Object obj;
    private Object advice;

    // 绑定代理对象
    public Object bind(Object obj, Advice advice) {
        this.obj = obj;
        this.advice = advice;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), this);
    }


    // 实现代理
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            ((Advice) advice).before();
            result = method.invoke(obj, args);
            ((Advice) advice).after();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
