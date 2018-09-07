package jdk.dongtaidaili.spring;

/**
 * Created by longshihan on 2017/4/30.
 */
public class TimeAdvice implements Advice {
    long startTime;
    long endTime;
    @Override
    public void before() {
        startTime = System.nanoTime(); // 获取开始时间
    }
    @Override
    public void after() {
        endTime = System.nanoTime(); // 获取结束时间
    }
}
