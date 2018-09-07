package jdk.dongtaidaili.spring;

/**
 * Created by longshihan on 2017/4/30.
 */
public class ControlAdvice implements Advice {
    @Override
    public void before() {
       System.out.println("before"+1);
    }
    @Override
    public void after() {
        System.out.println("after"+1);
    }
}
