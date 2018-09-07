package jdk.dongtaidaili.commonproxy;

/**
 * Created by dell on 2017/4/24.
 * 定义了一个类来实现这个接口，这个类就是我们的真实对象，
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
