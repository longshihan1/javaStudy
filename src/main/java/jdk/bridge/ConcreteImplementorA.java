package jdk.bridge;

/**
 * Created by dell on 2017/5/2.
 */
public class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("具体实现A ");
    }
}
