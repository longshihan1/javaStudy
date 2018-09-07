package Thread.ThreadDemo.jdk.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/3/1.
 */
public class TestYibu {
    public static Integer calc(Integer para) {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para /2;
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        final CompletableFuture<Void> future =
                CompletableFuture.supplyAsync(() -> calc(100))
                        .exceptionally(ex->{//错误处理
                            System.out.println(""+ex.toString());
                            return 0;
                        })
                        .thenCompose((i)->CompletableFuture.supplyAsync(()->calc(i)))//重新运行了calc
                        .thenApply((i) -> Integer.toString(i))//先将integer转成String
                        .thenApply((str) -> "\"" + str + "\"")//将引号起来
                        .thenAccept(System.out::println);
        future.get();
        System.out.println(" ssssss");
    }
}
