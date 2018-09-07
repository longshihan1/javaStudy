package Thread.ThreadDemo.jdk;

import java.util.stream.IntStream;

/**
 * 获取1-10000内的质数
 * Created by dell on 2017/3/1.
 */
public class TestPrime {
    public static void main(String args[]) {
        //filter过滤
        IntStream.range(1, 100000).filter(PrimeUtil::isPrime).count();//串行
        IntStream.range(1, 100000).parallel().filter(PrimeUtil::isPrime).count();//并行

    }
}
