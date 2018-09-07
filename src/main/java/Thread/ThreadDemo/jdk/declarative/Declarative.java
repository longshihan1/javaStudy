package Thread.ThreadDemo.jdk.declarative;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * 函数式编程
 * Created by dell on 2017/3/1.
 */
public class Declarative {

    public static void main(String args[]) {
        int[] iarr = {1, 2, 3, 4, 5, 6, 7, 8};
        //Arrays.stream(iarr).forEach(System.out::println);
        Arrays.stream(iarr).map((x) -> x = x + 1).forEach(System.out::println);

        Arrays.stream(iarr).forEach(System.out::println);

        Arrays.stream(iarr).map(x -> (x % 2 == 0 ? 0 : x + 1)).forEach(System.out::println);

        Arrays.stream(iarr).forEach(value -> System.out.println(" " + value));
        IntConsumer intConsumer=System.out::println;
    }
}
