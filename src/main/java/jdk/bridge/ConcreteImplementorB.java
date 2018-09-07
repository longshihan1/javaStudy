package jdk.bridge;

/**
 * Created by dell on 2017/5/2.
 */
public class ConcreteImplementorB implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("具体实现B ");
    }
}
